package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.ObjetsMetier.Agenda;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;


public class AgendaDao extends AbstractJpaDao<Long,Agenda>{

	public AgendaDao() {
		super(Agenda.class);
	}
}
