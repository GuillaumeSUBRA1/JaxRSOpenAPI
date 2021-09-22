package fr.istic.taa.ObjetsMetier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="Appointment")
public class Appointment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int duration;
	private boolean libre;
	private String date;
	private String subject;
	private User u;
	private Professionnal p;
	private Agenda a;
	
	
	public Appointment(int duration, boolean libre, String date, String subject, User u, Professionnal p) {
		super();
		this.duration = duration;
		this.libre = libre;
		this.date = date;
		this.subject = subject;
		this.u = u;
		this.p = p;
	}
	
	


	@XmlElement(name="date")
	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
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

	@XmlElement(name="duree")
	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}

	@XmlElement(name="objet")
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

	@OneToOne
	@XmlElement(name="user")
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@OneToOne
	@XmlElement(name="professionnal")
	public Professionnal getP() {
		return p;
	}

	public void setP(Professionnal p) {
		this.p = p;
	}

	@ManyToOne
	@XmlElement(name="agenda")
	public Agenda getA() {
		return a;
	}


	public void setA(Agenda a) {
		this.a = a;
	}

	@XmlElement(name="libre")
	public boolean isLibre() {
		return libre;
	}


	public void setLibre(boolean libre) {
		this.libre = libre;
	}




}
