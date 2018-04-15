package com.jdkcn.tomcat;


public class MyblogTomcatLauncher extends EmbeddedTomcatLauncher {
	public static void main(String[] args) {
		new MyblogTomcatLauncher().startTomcat();
	}

	protected String[] getContextsAbsolutePath() {
		return new String[] { "web" };
	}

	protected String[] getContextsMappingPath() {
		return new String[] { "/" };
	}

	protected String getTomcatPath() {
		return "embedTomcat";
	}
}
