package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.ObjetsMetier.Professionnal;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;


public class ProfessionalDao extends AbstractJpaDao<Long, Professionnal> {

    public ProfessionalDao(Class<Professionnal> professional) {
        super(professional);
    }
}
