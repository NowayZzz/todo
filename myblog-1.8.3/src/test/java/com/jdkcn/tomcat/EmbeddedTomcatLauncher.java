package com.jdkcn.tomcat;


import java.io.File;
import java.net.InetAddress;

import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Embedded;

public abstract class EmbeddedTomcatLauncher {
	private Embedded tomcat;

	protected EmbeddedTomcatLauncher() {
		initEmbedded();
		initShutdownHook();
	}

	protected abstract String[] getContextsAbsolutePath();

	protected abstract String[] getContextsMappingPath();

	protected abstract String getTomcatPath();

	protected void startTomcat() {
		try {
			long startTime = System.currentTimeMillis();
			tomcat.start();
			System.err.println("Embedded Tomcat started in "
					+ (System.currentTimeMillis() - startTime) + " ms.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initEmbedded(){
		tomcat = new Embedded();
		tomcat.setCatalinaBase(getTomcatPath());

		Host host = tomcat.createHost("localhost", tomcat.getCatalinaHome()
				+ "/webapps");

		String[] contexts = getContextsMappingPath();
		String[] contextsPath = getContextsAbsolutePath();
		Context context = null;

		for (int i = 0; i < contexts.length; ++i) {
			context = tomcat.createContext(contexts[i], new File(contextsPath[i]).getAbsolutePath());
			host.addChild(context);
		}

		Engine engine = tomcat.createEngine();
		engine.setName("MyDevAppServer");
		engine.addChild(host);
		engine.setDefaultHost(host.getName());

		tomcat.addEngine(engine);
		try {
//			Connector connector = tomcat.createConnector(InetAddress.getByName("192.168.0.128"), 8080, false); 
//			connector.setURIEncoding("UTF-8");
//			tomcat.addConnector(connector);
			
			Connector connector1 = tomcat.createConnector(InetAddress.getByName("127.0.0.1"), 8080, false); 
			connector1.setURIEncoding("UTF-8");
			connector1.setUseBodyEncodingForURI(true);
			tomcat.addConnector(connector1);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				stopTomcat();
			}
		});
	}

	private void stopTomcat() {
		try {
			tomcat.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
