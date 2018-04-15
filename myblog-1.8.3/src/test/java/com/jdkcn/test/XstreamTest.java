/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, jdkcn.com
 * Filename:		XstreamTest.java
 * Class:			XstreamTest
 * Date:			Dec 31, 2006 12:36:29 PM
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| Dec 31, 2006   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jdkcn.test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.jdkcn.domain.SiteConfig;
import com.jdkcn.yupoo.YupooPhoto;
import com.jdkcn.yupoo.YupooResult;
import com.thoughtworks.xstream.XStream;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since Dec 31, 2006 12:36:29 PM
 * @version $Id XstreamTest.java$
 */
public class XstreamTest extends TestCase {
	public void testWrite()throws Exception{
		XStream stream = new XStream();
		stream.alias("siteConfig", SiteConfig.class);
		SiteConfig siteConfig = new SiteConfig();
		siteConfig.setSiteName("莫多泡泡");
		siteConfig.setSiteSubName("Enjoy");
		siteConfig.setSiteSimpleAbout("简单介绍");
		siteConfig.setSiteAbout("关于我<a href=\"http://jdkcn.com\">Link</a>");
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("\n");
		sb.append(stream.toXML(siteConfig));
		System.out.println(sb);
	}
	
	public void testLoadFromYupoo() throws Exception {
//		File file = new File("src/test/java/com/jdkcn/test/result.xml");
		
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://www.yupoo.com/api/xmlrpc/"));
        config.setEnabledForExtensions(true);
        config.setEnabledForExceptions(true);
        config.setConnectionTimeout(60 * 1000);
        config.setReplyTimeout(60 * 1000);
        config.setBasicEncoding("UTF-8");
        
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Map<String,Object> params = new HashMap<String,Object>();
        String apiKey = "66a23c0893c9204714c6d49805d0d66f";
        params.put("api_key", apiKey);
        params.put("user_id", "ff8080810f1a387b010f1a83d6530dfc");
        
		//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		XStream stream = new XStream();
//		stream.registerConverter(new YupooResultConverter());
		stream.alias("result", YupooResult.class);
		stream.useAttributeFor("page", Integer.class);
		stream.useAttributeFor("pages", Integer.class);
		stream.useAttributeFor("perpage", Integer.class);
		stream.useAttributeFor("total", Integer.class);
		stream.alias("photo", YupooPhoto.class);
		stream.useAttributeFor("id", String.class);
		stream.useAttributeFor("owner", String.class);
		stream.useAttributeFor("title", String.class);
		stream.useAttributeFor("host", String.class);
		stream.useAttributeFor("dir", String.class);
		stream.useAttributeFor("filename", String.class);
		YupooResult result = (YupooResult)stream.fromXML((String)client.execute("yupoo.photos.search",new Object[]{params}));
		assertNotNull(result.getPhotos().get(0));
	}
}
