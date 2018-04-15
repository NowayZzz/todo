package com.jdkcn.test;

import com.jdkcn.dao.RoleDao;
import com.jdkcn.dao.UserDao;
import com.jdkcn.domain.Role;
import com.jdkcn.domain.User;

public class RoleDaoTest extends AbstractTestBean {
	
	protected RoleDao roleDao;
	
	protected UserDao userDao;
	
	public void testGetRolesByUsername() throws Exception {
		Role roleAdmin = createRole("Administrator");
		Role roleUser = createRole("User");
		User user = new User();
		user.addRole(roleAdmin);
		user.addRole(roleUser);
		user.setUsername("test");
		user.setPassword("test");
		user.setNickname("test");
		user.setMail("test@test.com");
		userDao.saveOrUpdate(user);
		assertEquals(2, roleDao.getRolesByUsername("test").size());
	}
	
	private Role createRole(String name) {
		Role role = new Role();
		role.setName(name);
		roleDao.saveOrUpdate(role);
		return role;
	}
}
