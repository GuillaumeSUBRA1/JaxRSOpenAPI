package fr.istic.taa.ObjetsMetier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@DiscriminatorValue("P")
@XmlRootElement(name="Professionnal")
public class Professionnal extends User implements Serializable {

	protected String job;

	private Agenda ag;
	protected Account ac;

	
	public Professionnal(String name, String surname, String job, Agenda ag, Account ac) {
		super(name, surname);
		this.job = job;
		this.ag = ag;
		this.ac = ac;
	}

	public Professionnal(String name, String surname, String job) {
		super(name, surname);
		this.job=job;
	}

	public Professionnal(){
		super();
	}


	@OneToOne
	@XmlElement(name="agenda")
	public Agenda getAg() {
		return ag;
	}

	public void setAg(Agenda ag) {
		this.ag = ag;
	}

	@OneToOne
	@XmlElement(name="account")
	public Account getAc() {
		return ac;
	}

	public void setAc(Account ac) {
		this.ac = ac;
	}

	@XmlElement(name="job")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
