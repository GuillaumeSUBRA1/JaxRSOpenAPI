package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.ObjetsMetier.Appointment ;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;


public class AppointmentDao extends  AbstractJpaDao<Long, Appointment>{

    public AppointmentDao() {
        super(Appointment.class);
    }

}
