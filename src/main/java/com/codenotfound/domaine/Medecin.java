package com.codenotfound.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Medecin")
public class Medecin {
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private String profession;
	
	@OneToMany(mappedBy="medecin")  
	private List<Consultation> consultation;

	public Medecin() {
		super();
	}

	public Medecin(int id, String nom, String prenom, String profession, List<Consultation> consultation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.profession = profession;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public List<Consultation> getConsultation() {
		return consultation;
	}

	public void setConsultation(List<Consultation> consultation) {
		this.consultation = consultation;
	}


}
