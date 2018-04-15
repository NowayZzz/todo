/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, jdkcn.com
 * Filename:		SimpleTest.java
 * Class:			SimpleTest
 * Date:			Sep 25, 2007 10:18:03 PM
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| Sep 25, 2007   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jdkcn.test;

import java.net.URLEncoder;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since Sep 25, 2007 10:18:03 PM
 * @version $Id SimpleTest.java$
 */
public class SimpleTest extends TestCase {
	public void testUrl() throws Exception{
		String url = "rory.cn@gmail.com呆呆";
		System.out.println(URLEncoder.encode(url, "UTF-8"));
	}
}
