package fr.istic.taa.ObjetsMetier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@XmlRootElement(name="Account")
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String password;
	private String login;
	private Professionnal p;
	
	public Account(String l, String pwd,Professionnal p) {
		super();
		this.password = pwd;
		this.login = l;
		this.p=p;
	}
	
	public Account(String l, String pwd) {
		super();
		this.password = pwd;
		this.login = l;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Account() {
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

	@XmlElement(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement(name="login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
