package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ol_usuario")
public class Usuario {
	@Id
	@SequenceGenerator(name="ol_usuario_seq", allocationSize=1, initialValue=3)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ol_usuario_seq")  
	private int user_id;
	private String user_user;
	private String user_pass;
	private Character user_carg;
	private Character user_esta;
	
	@ManyToOne
	@JoinColumn(name="pers_id")
	private Persona persona;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_user() {
		return user_user;
	}
	public void setUser_user(String user_user) {
		this.user_user = user_user;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public Character getUser_carg() {
		return user_carg;
	}
	public void setUser_carg(Character user_carg) {
		this.user_carg = user_carg;
	}
	public Character getUser_esta() {
		return user_esta;
	}
	public void setUser_esta(Character user_esta) {
		this.user_esta = user_esta;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
