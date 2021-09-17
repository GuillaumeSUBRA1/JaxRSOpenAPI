package fr.istic.taa.jpa;

import fr.istic.taa.ObjetsMetier.Account;
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
		
//		JpaTest t=new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			Professionnal p1=new Professionnal("Olivier","Barrais","Prof");
			Account ac1=new Account("login","password",p1);
			User u1= new User("Jean","Dupont");
			User u2=new User("Patrick","Bernard");
			User u3=new User("John","Rambo");
			
			
			acDao.save(ac1);
			uDao.save(p1);
			uDao.save(u1);
			uDao.save(u2);
			uDao.save(u3);
			
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
