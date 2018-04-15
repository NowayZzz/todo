/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, jdkcn.com
 * Filename:		CategoryDaoTest.java
 * Class:			CategoryDaoTest
 * Date:			Apr 18, 2007 2:34:43 PM
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| Apr 18, 2007   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jdkcn.test;

import java.util.Date;

import com.jdkcn.dao.CategoryDao;
import com.jdkcn.domain.Category;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since Apr 18, 2007 2:34:43 PM
 * @version $Id CategoryDaoTest.java$
 */
public class CategoryDaoTest extends AbstractTestBean {
	
	protected CategoryDao categoryDao;
	
	/**
	 * <code>
	 * parent_1
	 *    |_ch_p1_1
	 *    |_ch_p1_2
	 * parent_2
	 * </code>
	 * move ch_p1_1 to parent_2
	 * <code>
	 * parent_1
	 *    |_ch_p1_2
	 * parent_2
	 *    |_ch_p1_1
	 * </code>
	 * @throws Exception
	 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
	 */
	public void testMove()throws Exception{
		Category p1 = create("parent_1");
		Category p2 = create("parent_2");
		Category ch_p1_1 = create("ch_p1_1");
		ch_p1_1.setParent(p1);
		categoryDao.saveOrUpdate(ch_p1_1);
		
		System.out.println("before move:" + ch_p1_1);
		
		Category ch_p1_2 = create("ch_p1_2");
		ch_p1_2.setParent(p1);
		categoryDao.saveOrUpdate(ch_p1_2);
		p1.getChildren().add(ch_p1_2);
		p1.getChildren().add(ch_p1_1);
		categoryDao.saveOrUpdate(p1);
		assertEquals(2, categoryDao.get(p1.getId()).getChildren().size());
		
		categoryDao.move(ch_p1_1.getId(), p1.getId(), p2.getId());
		System.out.println("moved:" + ch_p1_1);
		
		assertEquals(1, categoryDao.get(p2.getId()).getChildren().size());
		
		assertEquals(1, categoryDao.get(p2.getId()).getChildren().size());
		
		categoryDao.move(ch_p1_2.getId(), p1.getId(), p2.getId());
		
		assertEquals(0, categoryDao.get(p1.getId()).getChildren().size());
		
		assertEquals(2, categoryDao.get(p2.getId()).getChildren().size());
	
	}
	
	private Category create(String name){
		Category cate = new Category();
		cate.setName(name);
		cate.setSecret(false);
		cate.setCreateTime(new Date());
		cate.setDefaultCategory(false);
		cate.setDescription(name + "'s description");
		categoryDao.saveOrUpdate(cate);
		return cate;
	}
}
