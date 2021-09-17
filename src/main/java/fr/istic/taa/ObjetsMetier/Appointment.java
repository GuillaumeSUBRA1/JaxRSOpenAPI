package fr.istic.taa.ObjetsMetier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Appointment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int duration;
	private String subject;
	private boolean libre;
	private User u;
	private Professionnal p;
	private Agenda a;
	
	
	public Appointment(int duration, String subject, boolean libre, User u, Professionnal p) {
		super();
		this.duration = duration;
		this.subject = subject;
		this.libre = libre;
		this.u=u;
		this.p=p;
	}
	

	public Appointment(){
		super();
	}


	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public boolean isLibre() {
		return libre;
	}


	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	@OneToOne
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@OneToOne
	public Professionnal getP() {
		return p;
	}

	public void setP(Professionnal p) {
		this.p = p;
	}

	@ManyToOne
	public Agenda getA() {
		return a;
	}


	public void setA(Agenda a) {
		this.a = a;
	}




}
