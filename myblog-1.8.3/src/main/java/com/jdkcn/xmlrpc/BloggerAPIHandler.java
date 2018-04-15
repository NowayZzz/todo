/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, jdkcn.com
 * Filename:		BloggerAPIHandler.java
 * Class:			BloggerAPIHandler
 * Date:			Dec 18, 2008 4:15:34 PM
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| Dec 18, 2008   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jdkcn.xmlrpc;

import java.util.Hashtable;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlrpc.XmlRpcException;

import com.jdkcn.domain.Entry;
import com.jdkcn.domain.User;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since Dec 18, 2008 4:15:34 PM
 * @version $Id BloggerAPIHandler.java$
 */
public class BloggerAPIHandler extends BaseAPIHandler {
	
	private static final long serialVersionUID = 1808766397348317870L;
	
	private static final Log log = LogFactory.getLog(BloggerAPIHandler.class);
	
    /**
     * Delete a Post
     *
     * @param appkey Unique identifier/passcode of the application sending the post
     * @param postid Unique identifier of the post to be changed
     * @param userid Login for a Blogger user who has permission to post to the blog
     * @param password Password for said username
     * @param publish Ignored
     * @throws XmlRpcException
     * @return
     */
    public boolean deletePost(String appkey, String postid, String userid,
            String password, boolean publish) throws Exception {
        if (log.isDebugEnabled()) {
	        log.debug("deletePost() Called =====[ SUPPORTED ]=====");
	        log.debug("     Appkey: " + appkey);
	        log.debug("     PostId: " + postid);
	        log.debug("     UserId: " + userid);
        }
        
        
        Entry entry = blogFacade.getEntry(postid);
        
        // Return false if entry not found
        if (entry == null) return false;
        
        validate("", userid, password);
        
        try {
        	// delete the entry
            blogFacade.removeEntry(postid);
        } catch (Exception e) {
            String msg = "ERROR in blogger.deletePost: "+e.getClass().getName();
            log.error(msg,e);
            throw new XmlRpcException(UNKNOWN_EXCEPTION, msg);
        }
        
        return true;
    }
    
    /**
     * Returns information on all the blogs a given user is a member of
     *
     * @param appkey Unique identifier/passcode of the application sending the post
     * @param userid Login for a Blogger user who has permission to post to the blog
     * @param password Password for said username
     * @throws XmlRpcException
     * @return
     */
    @SuppressWarnings("unchecked")
	public Object getUsersBlogs(String appkey, String userid, String password) throws Exception {
        if (log.isDebugEnabled()) {
	        log.debug("getUsersBlogs() Called ===[ SUPPORTED ]=======");
	        log.debug("     Appkey: " + appkey);
	        log.debug("     UserId: " + userid);
        }
        Vector result = new Vector();
        if (validateUser(userid, password)) {
            try {
	            Hashtable blog = new Hashtable();
	            blog.put("url", blogFacade.getDatabaseSiteConfig().getSiteURL());
	            blog.put("blogid", "");
	            blog.put("blogName", blogFacade.getDatabaseSiteConfig().getSiteName());
	            result.add(blog);
            } catch (Exception e) {
                String msg = "ERROR in BlooggerAPIHander.getUsersBlogs";
                log.error(msg,e);
                throw new XmlRpcException(UNKNOWN_EXCEPTION, msg);
            }
        }
        return result;
    }
    
    /**
     * Authenticates a user and returns basic user info (name, email, userid, etc.)
     *
     * @param appkey Unique identifier/passcode of the application sending the post
     * @param userid Login for a Blogger user who has permission to post to the blog
     * @param password Password for said username
     * @throws XmlRpcException
     * @return
     */
    @SuppressWarnings("unchecked")
	public Object getUserInfo(String appkey, String userid, String password) throws Exception {
        if (log.isDebugEnabled()) {
	        log.debug("getUserInfo() Called =====[ SUPPORTED ]=====");
	        log.debug("     Appkey: " + appkey);
	        log.debug("     UserId: " + userid);
        }
        validateUser(userid, password);
        
        try {
            User user = blogFacade.getUserByUsername(userid);
            
            Hashtable result = new Hashtable();
            result.put("nickname", user.getNickname());
            result.put("userid", user.getUsername());
            result.put("email", user.getMail());
            result.put("lastname", "");
            result.put("firstname", "");
            return result;
        } catch (Exception e) {
            String msg = "ERROR in BlooggerAPIHander.getInfo";
            log.error(msg,e);
            throw new XmlRpcException(UNKNOWN_EXCEPTION,msg);
        }
    }
    
    
    
}
