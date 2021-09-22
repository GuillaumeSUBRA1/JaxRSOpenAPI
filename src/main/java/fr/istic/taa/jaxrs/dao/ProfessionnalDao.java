package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.ObjetsMetier.Professionnal;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;


public class ProfessionnalDao extends AbstractJpaDao<Long, Professionnal> {

    public ProfessionnalDao() {
        super(Professionnal.class);
    }
}
