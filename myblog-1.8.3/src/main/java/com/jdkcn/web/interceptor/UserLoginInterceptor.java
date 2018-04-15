/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, leaf.jdk.cn
 * Filename:		UserLoginInterceptor.java
 * Module:			Dream
 * Class:			UserLoginInterceptor
 * Date:			2006-7-9 下午03:32:04
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| 2006-7-9   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jdkcn.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jdkcn.BlogFacade;
import com.jdkcn.domain.User;
import com.jdkcn.exception.InvalidPasswordException;
import com.jdkcn.exception.InvalidUsernameException;
import com.jdkcn.util.Constants;
import com.jdkcn.util.CookieUtil;
import com.jdkcn.util.HttpUtil;


/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-7-9 03:32:04 PM
 * @version $Id UserLoginInterceptor.java$
 */
public class UserLoginInterceptor extends HandlerInterceptorAdapter {
	private static final String COOKIE_NAME_USERNAME = "username";

	private static final String COOKIE_NAME_PASSWORD = "password";

	private String loginView;

	private BlogFacade blogFacade;

	public void setLoginView(String loginView) {
		this.loginView = loginView;
	}

	public void setBlogFacade(BlogFacade blogFacade) {
		this.blogFacade = blogFacade;
	}

	public String getLoginView() {
		return loginView;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		// check session.
		User loggedInUser = (User) session.getAttribute(Constants.AUTH_USER);
		
		// check cookie, if user not found in the session.
		if (loggedInUser == null && (loggedInUser = this.retrieveUserFromCookie(request)) != null) {
			// if find user in cookie, put it to session.
			session.setAttribute(Constants.AUTH_USER, loggedInUser);
		}

		// no user found, save the preview page.
		if (loggedInUser == null) {
			session.setAttribute(Constants.ORIGINAL_URL, HttpUtil.buildOriginalGETURL(request));
			throw new ModelAndViewDefiningException(new ModelAndView(getLoginView()));
		}
		
		return true;
	}

	/**
	 * Retrive user from cookie.
	 * 
	 * @param request
	 *            a http request
	 * @return authenticated user by username and password that save in cookie,
	 *         return null if no corrent user found.
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	private User retrieveUserFromCookie(HttpServletRequest request) {
		User user = null;
		String username = CookieUtil.getCookieValue(request, COOKIE_NAME_USERNAME, StringUtils.EMPTY);
		String password = CookieUtil.getCookieValue(request, COOKIE_NAME_PASSWORD, StringUtils.EMPTY);
		if (StringUtils.isNotBlank(password)
				&& StringUtils.isNotBlank(username)) {
			try {
				user = blogFacade.cookieLogin(username, password);
			} catch (InvalidUsernameException ex) {
			} catch (InvalidPasswordException ex) {
			}
		}
		return user;
	}
}
