package fr.istic.taa.jpa;

import fr.istic.taa.ObjetsMetier.Account;
import fr.istic.taa.ObjetsMetier.Appointment;
import fr.istic.taa.ObjetsMetier.Professionnal;
import fr.istic.taa.ObjetsMetier.User;

import fr.istic.taa.jaxrs.dao.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

public class JpaTest {

	
//	private EntityManager manager;
	
/*	public JpaTest(EntityManager m) {
		this.manager=m;
	}
*/	
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
		Root<User> from = query.from(User.class);

		UserDao uDao=new UserDao();
		AccountDao acDao=new AccountDao();
		AppointmentDao apDao=new AppointmentDao();
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			Professionnal p1=new Professionnal("Olivier","Barrais","Prof");
			Professionnal p2=new Professionnal("John","Rambo","Acteur");
			Account ac1=new Account("login1","password1",p1);
			Account ac2=new Account("login2","password2",p2);
			User u1= new User("Jean","Dupont");
			User u2=new User("Patrick","Bernard");
			User u3=new User("Adam","McDonald");
			
			Appointment ap1=new Appointment(15,false,"01/02/2020","Cours Java",u1,p1);
			Appointment ap2=new Appointment(30,false,"14/08/2018","Cours Java",u2,p1);
			Appointment ap3=new Appointment(10,false,"16/09/2021","Cours Cinema",u3,p2);
			
			
			uDao.save(p1);
			uDao.save(p2);
			acDao.save(ac1);
			acDao.save(ac2);
			uDao.save(u1);
			uDao.save(u2);
			uDao.save(u3);
			apDao.save(ap1);
			apDao.save(ap2);
			apDao.save(ap3);
			
			System.out.println("------\n");
			query.select(from.get("name")).where(from.get("name").in(1));

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		uDao.findAll();
		acDao.findAll();
		manager.close();
		factory.close();
		
		
	}
	

}
