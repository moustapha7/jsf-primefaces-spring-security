package com.codenotfound.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

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
	
	
	@ManyToOne
	private Medecin medecin;
	

	@ManyToOne
	private Patient patient;
	
	/*@JsonIgnore
	@OneToMany
	private List<Ordonnance> ordonnances;*/

	@ManyToOne
	private Ordonnance ordonnance;
	
	@Nullable
	private String autreMedicament;
	
	public Consultation() {
		
	}

	public Consultation(int id, String nom, String details, String numero, String date, Medecin medecin,
			Patient patient, Ordonnance ordonnance,String autreMedicament) {
		super();
		this.id = id;
		this.nom = nom;
		this.details = details;
		this.numero = numero;
		this.date = date;
		this.medecin = medecin;
		this.patient = patient;
		this.ordonnance = ordonnance;
		this.autreMedicament= autreMedicament;
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

	public String getAutreMedicament() {
		return autreMedicament;
	}

	public void setAutreMedicament(String autreMedicament) {
		this.autreMedicament = autreMedicament;
	}

	@Override
	public String toString() {
		return "Consultation [id=" + id + ", nom=" + nom + ", details=" + details + ", numero=" + numero + ", date="
				+ date + ", medecin=" + medecin + ", patient=" + patient + ", ordonnance=" + ordonnance
				+ ", autreMedicament=" + autreMedicament + "]";
	}
	
	

	



	

}
