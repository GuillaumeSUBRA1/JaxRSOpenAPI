package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.ObjetsMetier.Account;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;


public class AccountDao extends AbstractJpaDao<Long,Account>{
	public AccountDao() {
		super(Account.class);
	}
}
