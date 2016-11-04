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
@Table(name="ol_persona")
public class Persona {

	@Id
	@SequenceGenerator(name="ol_persona_seq", allocationSize=1, initialValue=4)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ol_persona_seq")  
	private int pers_id;
	private String pers_nomb;
	private String pers_apel;
	private String pers_dire;
	@ManyToOne
	@JoinColumn(name="pais_id")
	private Pais pais;
	private Character pers_esta;
	public int getPers_id() {
		return pers_id;
	}
	public void setPers_id(int pers_id) {
		this.pers_id = pers_id;
	}
	public String getPers_nomb() {
		return pers_nomb;
	}
	public void setPers_nomb(String pers_nomb) {
		this.pers_nomb = pers_nomb;
	}
	public String getPers_apel() {
		return pers_apel;
	}
	public void setPers_apel(String pers_apel) {
		this.pers_apel = pers_apel;
	}
	public String getPers_dire() {
		return pers_dire;
	}
	public void setPers_dire(String pers_dire) {
		this.pers_dire = pers_dire;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Character getPers_esta() {
		return pers_esta;
	}
	public void setPers_esta(Character pers_esta) {
		this.pers_esta = pers_esta;
	}
	
	
}
