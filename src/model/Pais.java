package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ol_pais")
public class Pais {
	@Id
	@SequenceGenerator(name="ol_pais_seq", allocationSize=1, initialValue=5)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ol_pais_seq")  
	private int pais_id;
	private String pais_nomb;
	public int getPais_id() {
		return pais_id;
	}
	public void setPais_id(int pais_id) {
		this.pais_id = pais_id;
	}
	public String getPais_nomb() {
		return pais_nomb;
	}
	public void setPais_nomb(String pais_nomb) {
		this.pais_nomb = pais_nomb;
	}
	
	

}
