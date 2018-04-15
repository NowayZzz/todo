package com.jdkcn.util;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class HttpUtil {

	private HttpUtil(){}
	
	/** HTTP method "GET" */
	public static final String METHOD_GET = "GET";

	/** HTTP method "POST" */
	public static final String METHOD_POST = "POST";
	
	/**
	 * Build the original url for the request.
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String buildOriginalURL(HttpServletRequest request) {
		StringBuffer originalURL = request.getRequestURL();
		Map<String, String[]> parameters = request.getParameterMap();
		if (parameters != null && parameters.size() > 0) {
			originalURL.append("?");
			for (Map.Entry<String, String[]> entry :parameters.entrySet()) {
				String key = entry.getKey();
				String[] values = entry.getValue();
				for (String value : values) {
					originalURL.append(key).append("=").append(value).append("&");
				}
			}
		}
		if (originalURL.toString().endsWith("&")) {
			return originalURL.toString().substring(0, originalURL.toString().length()-1);
		}
		return originalURL.toString();
	}
	
	/**
	 * Build the original <tt>GET</tt> url for the request.
	 * @param request
	 * @return
	 */
	public static String buildOriginalGETURL(HttpServletRequest request) {
		if (request.getMethod().equals(METHOD_POST)) {
			return request.getRequestURL().toString();
		}
		return buildOriginalURL(request);
	}

    public static void printCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                System.out.print("cookie name = [" + cookies[i].getName() + "]\t\t");
                System.out.println("cookie value = [" + cookies[i].getValue());
            }
        }
    }

}
