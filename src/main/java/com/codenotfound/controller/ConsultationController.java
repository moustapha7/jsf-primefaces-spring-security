package com.codenotfound.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.domaine.AppRole;
import com.codenotfound.domaine.AppUser;
import com.codenotfound.domaine.Consultation;
import com.codenotfound.domaine.Medecin;
import com.codenotfound.domaine.Ordonnance;
import com.codenotfound.domaine.Patient;
import com.codenotfound.repository.ConsultationRepository;
import com.codenotfound.repository.MedecinRepository;
import com.codenotfound.repository.OrdonnanceRepository;
import com.codenotfound.repository.PatientRepository;


@Named
@SessionScoped
public class ConsultationController implements Serializable {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	@Autowired
	private MedecinRepository medecinRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private OrdonnanceRepository ordonnanceRepository;
	
	private Consultation consultation;
	
	private String message ;
	
	private List<Consultation> consultations;
	
	private List<Ordonnance> ordonnances;
	
	private List<Patient> patients;
	
	private List<Medecin> medecins;
	
	
	/*******getter  setter ********************/
	

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Consultation> getConsultations() {
		
		consultations = consultationRepository.findAll();
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	
	
	
	
	
	
	public List<Ordonnance> getOrdonnances() {
		ordonnances= ordonnanceRepository.findAll();
		return ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public List<Patient> getPatients() {
		patients= patientRepository.findAll();
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Medecin> getMedecins() {
		medecins= medecinRepository.findAll();
		return medecins;
	}

	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

	/****************************************************************************/
	
	
	public ConsultationController() {
	
	}
	
	@PostConstruct
	private void initConsultation() {
		
		consultation= new Consultation();
		consultation.setMedecin(new Medecin());
		consultation.setPatient(new Patient());
		consultation.setOrdonnance(new Ordonnance());
		consultation.setOrdonnance2(new Ordonnance());
		consultation.setOrdonnance3(new Ordonnance());
		consultation.setOrdonnance4(new Ordonnance());
		getConsultations();
		getPatients();
		getOrdonnances();
	}
	
	
	
	
	
	
	
	
	/*********************************CRUD***************************************************/
	
	
	
	 public String deleteConsultation(Consultation consultation){
	        try {
	            consultationRepository.delete(consultation);
	            this.consultation = new Consultation();
	            return "consultation?faces-redirect=true";
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return "listConsultation";
	    }
	 
	 
	 public String editConsultation(Consultation consultation){
	        try {
	            this.consultation = consultation ;
	            return "editConsultation?faces-redirect=true";
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return "editConsultation?faces-redirect=true";
	    }
		
		
	    public String detailsConsultation(Consultation consultation){
	        try {
	            this.consultation = consultation ;
	            return "detailsConsultation?faces-redirect=true";
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return "detailsConsultation?faces-redirect=true";
	    }

	    public String updateConsultation(){
	        try {
	            consultationRepository.save(consultation);
	            consultation = new Consultation();
	            return "consultation?faces-redirect=true";
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return "consultation?faces-redirect=true";
	    }
	    
	    
	    public String addConsultation() {
	        try {
	           Patient pa = patientRepository.findById(consultation.getPatient().getId());
	           Medecin me = medecinRepository.findById(consultation.getMedecin().getId());
	           Ordonnance or = ordonnanceRepository.findById(consultation.getOrdonnance().getId());
	           
	           consultationRepository.save( consultation);
	            
	     
	            System.out.println("Success!!!");
	            consultation =new  Consultation();
	            return " consultation?faces-redirect=true";
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        return " consultation?error=1&faces-redirect=true";
	    }
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*********************************CRUD***************************************************/
	
	

}
