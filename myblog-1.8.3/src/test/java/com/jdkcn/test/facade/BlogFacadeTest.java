/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, jdkcn.com
 * Filename:		BlogFacadeTest.java
 * Class:			BlogFacadeTest
 * Date:			2006-9-15
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| 2006-9-15   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jdkcn.test.facade;

import java.util.Date;

import com.jdkcn.BlogFacade;
import com.jdkcn.domain.Comment;
import com.jdkcn.domain.Entry;
import com.jdkcn.domain.Role;
import com.jdkcn.domain.User;
import com.jdkcn.test.AbstractTestBean;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since 2006-9-15
 * @version $Id BlogFacadeTest.java$
 */
public class BlogFacadeTest extends AbstractTestBean {
	protected BlogFacade blogFacade;
	
	public void testEntryCRUD() throws Exception{
		Entry entry = new Entry();
		entry.setTitle("Test entry");
		entry.setContent("Welcome to first entry");
		entry.setAuthor(createUser("poster"));
		entry.setPostIP("127.0.0.1");
		entry.setPostTime(new Date());
		entry.setEntryStatus(Entry.EntryStatus.PUBLISH);
		entry.setCommentStatus(Entry.CommentStatus.OPEN);
		blogFacade.saveOrUpdateEntry(entry);
		
		Entry saved = blogFacade.getEntry(entry.getId());
		assertEquals(saved.getTitle(), "Test entry");
		
	}
	
	public void testRemoveEntry() throws Exception {
		Entry entry = new Entry();
		entry.setTitle("Test entry");
		entry.setContent("Welcome to first entry");
		entry.setAuthor(createUser("poster"));
		entry.setPostIP("127.0.0.1");
		entry.setPostTime(new Date());
		entry.setEntryStatus(Entry.EntryStatus.PUBLISH);
		entry.setCommentStatus(Entry.CommentStatus.OPEN);
		blogFacade.saveOrUpdateEntry(entry);
		
		Comment comment = new Comment();
		comment.setEntry(entry);
		comment.setAuthorName("guest1");
		comment.setAuthorMail("guest1@jdkcn.com");
		comment.setContent("test comment1");
		comment.setPostIP("127.0.0.1");
		comment.setPostTime(new Date());
		blogFacade.saveOrUpdateComment(comment);
		
		assertEquals(1, blogFacade.getCommentListByEntryId(entry.getId()).size());
		
		Comment commentA = new Comment();
		commentA.setEntry(entry);
		commentA.setAuthorName("guest1");
		commentA.setAuthorMail("guest1@jdkcn.com");
		commentA.setContent("test comment1");
		commentA.setPostIP("127.0.0.1");
		commentA.setPostTime(new Date());
		blogFacade.saveOrUpdateComment(commentA);
		
		assertEquals(2, blogFacade.getCommentListByEntryId(entry.getId()).size());
		
		blogFacade.removeEntry(entry.getId());
		
		assertEquals(0, blogFacade.getCommentListByEntryId(entry.getId()).size());
	}
	
	public void testUserCRUD() throws Exception {
		Role roleAdmin = createRole("Administrator");
		Role roleUser = createRole("User");
		User user = new User();
		user.addRole(roleAdmin);
		user.addRole(roleUser);
		user.setUsername("test");
		user.setPassword("test");
		user.setMail("test@test.com");
		blogFacade.saveOrUpdateUser(user);
		User savedUser = blogFacade.getUserByUsername("test");
		assertEquals(2, savedUser.getRoles().size());
		System.out.println(savedUser.getRoles().get(0).getName());
	}
	
	private User createUser(String username) {
		User user = new User();
		user.setUsername(username);
		user.setNickname(username);
		user.setMail(username+"@jdkcn.com");
		user.setPassword(username);
		blogFacade.saveOrUpdateUser(user);
		return user;
	}
	
	private Role createRole(String name) {
		Role role = new Role();
		role.setName(name);
		blogFacade.saveOrUpdateRole(role);
		return role;
	}
	
	
}
