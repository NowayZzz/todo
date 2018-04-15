/**
 * <pre>
 * Copyright:		Copyright(C) 2002-2006, jdkcn.com
 * Filename:		RoleDaoHibernateImpl.java
 * Class:			RoleDaoHibernateImpl
 * Date:			Oct 7, 2006
 * Author:			<a href="mailto:rory.cn@gmail.com">somebody</a>
 * Description:		
 *
 *
 * ======================================================================
 * Change History Log
 * ----------------------------------------------------------------------
 * Mod. No.	| Date		| Name			| Reason			| Change Req.
 * ----------------------------------------------------------------------
 * 			| Oct 7, 2006   | Rory Ye	    | Created			|
 *
 * </pre>
 **/
package com.jdkcn.dao.hibernate3;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.jdkcn.dao.RoleDao;
import com.jdkcn.domain.Role;

/**
 * @author <a href="mailto:rory.cn@gmail.com">somebody</a>
 * @since Oct 7, 2006
 * @version $Id RoleDaoHibernateImpl.java$
 */
public class RoleDaoHibernateImpl extends BaseHibernateDaoSupport<Role>
		implements RoleDao {

	public List<Role> getRolesByUsername(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
		criteria.createCriteria("users").add(Restrictions.eq("username", username));
		return getListByCriteria(criteria);
	}

	
}
