package com.codenotfound.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.domaine.Medecin;
import com.codenotfound.repository.MedecinRepository;


@Named
@SessionScoped
public class MedecinController implements Serializable{
	
	@Autowired
	private MedecinRepository medecinRepository;

	public MedecinController() {
		
	}
	
	@PostConstruct
    public void init(){
        medecin = new Medecin();
        getMedecins();
    }

    private Medecin medecin;
    private List< Medecin> medecins;


    public List<Medecin> getMedecins() {
        medecins = medecinRepository.findAll();
        if(medecins == null) medecins = new ArrayList<>();
        return medecins;
    }


   public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

  	
	
    public Medecin getMedecin() {
	return medecin;
}

public void setMedecin(Medecin medecin) {
	this.medecin = medecin;
}

	public String deleteMedecin(Medecin medecin){
        try {
            medecinRepository.delete(medecin);
            return "medecin?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "listMedecin";
    }

    public String editMedecin(Medecin medecin){
        try {
            this.medecin = medecin ;
            return "editMedecin?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "editMedecin?faces-redirect=true";
    }

    public String updateMedecin(){
        try {
            medecinRepository.save(medecin);
            medecin = new Medecin();
            return "medecin?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "medecin?faces-redirect=true";
    }


    public String addMedecin() {
        try {
            medecinRepository.save(medecin);
            System.out.println("Success!!!");
           medecin = new Medecin();
            return "listMedecin?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "listMedecin?faces-redirect=true";
    }

	

}
