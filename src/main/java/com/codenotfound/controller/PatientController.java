package com.codenotfound.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.domaine.Patient;
import com.codenotfound.repository.PatientRepository;


@Named
@SessionScoped
public class PatientController  implements Serializable  {
	
	
	@Autowired
	private PatientRepository patientRepository;

	public PatientController() {
		
	}
	
	@PostConstruct
    public void init(){
        patient = new Patient();
        getPatients();
    }

    private Patient patient;
    private List< Patient> patients;


    public List<Patient> getPatients() {
        patients = patientRepository.findAll();
        if(patients == null) patients = new ArrayList<>();
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }







   public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	
    public String deletePatient(Patient patient){
        try {
            patientRepository.delete(patient);
            return "patient?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "listPatient";
    }

    public String editPatient(Patient patient){
        try {
            this.patient = patient ;
            return "editPatient?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "editPatient?faces-redirect=true";
    }

    public String updatePatient(){
        try {
            patientRepository.save(patient);
            patient = new Patient();
            return "patient?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "patient?faces-redirect=true";
    }


    public String addPatient() {
        try {
            patientRepository.save(patient);
            System.out.println("Success!!!");
           patient = new Patient();
            return "listPatient?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "listPatient?faces-redirect=true";
    }

	
	
	

}
