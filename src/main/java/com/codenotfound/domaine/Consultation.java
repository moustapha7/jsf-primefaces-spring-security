package com.codenotfound.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="Consultation")
public class Consultation {
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String details;
	private String numero;
	private String date;
	
	@JsonIgnore
	@ManyToOne
	private Medecin medecin;
	
	@JsonIgnore
	@ManyToOne
	private Patient patient;
	
	@JsonIgnore
	@ManyToOne
	private Ordonnance ordonnance;

	@JsonIgnore
	@ManyToOne
	private Ordonnance ordonnance2;
	
	@JsonIgnore
	@ManyToOne
	private Ordonnance ordonnance3;
	
	@JsonIgnore
	@ManyToOne
	private Ordonnance ordonnance4;

	
	public Consultation() {
		super();
	}




	public Consultation(int id, String nom, String details, String numero, String date, Medecin medecin,
			Patient patient, Ordonnance ordonnance, Ordonnance ordonnance2, Ordonnance ordonnance3,
			Ordonnance ordonnance4) {
		super();
		this.id = id;
		this.nom = nom;
		this.details = details;
		this.numero = numero;
		this.date = date;
		this.medecin = medecin;
		this.patient = patient;
		this.ordonnance = ordonnance;
		this.ordonnance2 = ordonnance2;
		this.ordonnance3 = ordonnance3;
		this.ordonnance4 = ordonnance4;
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




	public String getDetails() {
		return details;
	}




	public void setDetails(String details) {
		this.details = details;
	}




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public Medecin getMedecin() {
		return medecin;
	}




	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}




	public Patient getPatient() {
		return patient;
	}




	public void setPatient(Patient patient) {
		this.patient = patient;
	}




	public Ordonnance getOrdonnance() {
		return ordonnance;
	}




	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}




	public Ordonnance getOrdonnance2() {
		return ordonnance2;
	}




	public void setOrdonnance2(Ordonnance ordonnance2) {
		this.ordonnance2 = ordonnance2;
	}




	public Ordonnance getOrdonnance3() {
		return ordonnance3;
	}




	public void setOrdonnance3(Ordonnance ordonnance3) {
		this.ordonnance3 = ordonnance3;
	}




	public Ordonnance getOrdonnance4() {
		return ordonnance4;
	}




	public void setOrdonnance4(Ordonnance ordonnance4) {
		this.ordonnance4 = ordonnance4;
	}


}
