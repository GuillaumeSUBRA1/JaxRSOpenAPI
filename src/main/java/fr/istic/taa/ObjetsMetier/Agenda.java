package fr.istic.taa.ObjetsMetier;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@Entity
@XmlRootElement(name="Agenda")
public class Agenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String url;
	protected Professionnal p;
	private Collection<Appointment> a;
	
	public Agenda(String url, Professionnal p) {
		super();
		this.url = url;
		this.p=p;
	}
	


	public Agenda() {
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

	@XmlElement(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@OneToMany(mappedBy="a")
	@XmlElement(name="listappointment")
	public Collection<Appointment> getA() {
		return a;
	}

	public void setA(Collection<Appointment> a) {
		this.a = a;
	}

	@OneToOne
	@XmlElement(name="professionnal")
	public Professionnal getP() {
		return p;
	}

	public void setP(Professionnal p) {
		this.p = p;
	}
	

}
