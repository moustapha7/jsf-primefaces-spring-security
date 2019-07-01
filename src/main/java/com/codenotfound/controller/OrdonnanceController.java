package com.codenotfound.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.codenotfound.domaine.Ordonnance;
import com.codenotfound.repository.OrdonnanceRepository;


@Named
@SessionScoped
public class OrdonnanceController implements Serializable {
	
	@Autowired
	private OrdonnanceRepository ordonnanceRepository;

	public OrdonnanceController() {
		
	}
	
	@PostConstruct
    public void init(){
		ordonnance = new Ordonnance();
        getOrdonnances();
    }

    private Ordonnance ordonnance;
    private List< Ordonnance> ordonnances;


    public List<Ordonnance> getOrdonnances() {
    	ordonnances = ordonnanceRepository.findAll();
        if(ordonnances == null) ordonnances = new ArrayList<>();
        return ordonnances;
    }

  

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public String deleteOrdonnance(Ordonnance ordonnance){
        try {
        	ordonnanceRepository.delete(ordonnance);
            return "ordonnance?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "listOrdonnance";
    }

    public String editOrdonnance(Ordonnance ordonnance){
        try {
            this.ordonnance = ordonnance ;
            return "editOrdonnance?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "editOrdonnance?faces-redirect=true";
    }

    public String updateOrdonnance(){
        try {
        	ordonnanceRepository.save(ordonnance);
        	ordonnance = new Ordonnance();
            return "ordonnance?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "ordonnance?faces-redirect=true";
    }


    public String addOrdonnance() {
        try {
        	ordonnanceRepository.save(ordonnance);
            System.out.println("Success!!!");
            ordonnance = new Ordonnance();
            return "listOrdonnance?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "listOrdonnance?faces-redirect=true";
    }

	

}
