package com.codenotfound.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="Ordonnance")
public class Ordonnance {
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private int prix;
	
	/*@OneToMany
	private List<Consultation> consultations;
	*/
	@OneToMany(mappedBy="ordonnance")  
	private List<Consultation> consultation;
	
	public Ordonnance() {
		
	}


	

	public Ordonnance(int id, String nom, int prix, List<Consultation> consultation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.consultation = consultation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public List<Consultation> getConsultation() {
		return consultation;
	}

	public void setConsultation(List<Consultation> consultation) {
		this.consultation = consultation;
	}
	
	

}
