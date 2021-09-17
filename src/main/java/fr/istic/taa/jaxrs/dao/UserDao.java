package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.ObjetsMetier.User;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;


public class UserDao extends AbstractJpaDao<Long,User>{
	
	public UserDao() {
		super(User.class);
	}

}
