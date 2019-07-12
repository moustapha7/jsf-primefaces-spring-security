package com.codenotfound.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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
	
	private StreamedContent file;
	
	private String message ;
	
	private List<Consultation> consultations;
	
	private List<Ordonnance> ordonnances;
	
	private List<Patient> patients;
	
	private List<Medecin> medecins;
	
	
	private Integer selectedMedecin ;
    private Integer selectedPatient;
    private Integer selectedOrdonnance ;
    
    private List<Medecin> selectedMedecins;
    
    private List<Consultation> selectedConsultations;
	
	private List<Ordonnance> selectedOrdonnances;
	
	private List<Patient> selectedPatients;
	
	
	/*******getter  setter ********************/
	

	
	
	
	public Consultation getConsultation() {
		return consultation;
	}

	public Integer getSelectedMedecin() {
		return selectedMedecin;
	}

	public void setSelectedMedecin(Integer selectedMedecin) {
		this.selectedMedecin = selectedMedecin;
	}

	public Integer getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Integer selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public Integer getSelectedOrdonnance() {
		return selectedOrdonnance;
	}

	public void setSelectedOrdonnance(Integer selectedOrdonnance) {
		this.selectedOrdonnance = selectedOrdonnance;
	}

	public List<Medecin> getSelectedMedecins() {
		return selectedMedecins;
	}

	public void setSelectedMedecins(List<Medecin> selectedMedecins) {
		this.selectedMedecins = selectedMedecins;
	}

	public List<Consultation> getSelectedConsultations() {
		return selectedConsultations;
	}

	public void setSelectedConsultations(List<Consultation> selectedConsultations) {
		this.selectedConsultations = selectedConsultations;
	}

	public List<Ordonnance> getSelectedOrdonnances() {
		return selectedOrdonnances;
	}

	public void setSelectedOrdonnances(List<Ordonnance> selectedOrdonnances) {
		this.selectedOrdonnances = selectedOrdonnances;
	}

	public List<Patient> getSelectedPatients() {
		return selectedPatients;
	}

	public void setSelectedPatients(List<Patient> selectedPatients) {
		this.selectedPatients = selectedPatients;
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
		
		this.consultation = new Consultation();
        this.consultation.setOrdonnance(new Ordonnance());
        this.consultation.setMedecin(new Medecin());
        this.consultation.setPatient(new Patient());
      
		
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/dossierMedical/ficheMedical.jpg");
        file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_ficheMedical.jpg");
	
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
	        	Patient pa= new Patient();
	        	Medecin me = new Medecin ();
	        	Ordonnance or =new Ordonnance();
	            pa = patientRepository.findById(selectedPatient);
	            me = medecinRepository.findById(selectedMedecin);
	            or = ordonnanceRepository.findById(selectedOrdonnance);
	            
	            if(pa!=null)
	            {
	            	consultation.setPatient(pa);
	            }
	            if(me!=null)
	            {
	            	consultation.setMedecin(me);
	            }
	            if(or!=null)
	            {
	            	consultation.setOrdonnance(or);
	            }
	           
	            
	            consultation = consultationRepository.save( consultation);
	            
	     
	            System.out.println("Success!!!");
	            consultation =new  Consultation();
	           // return " consultation?faces-redirect=true";
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        return " consultation?error=1&faces-redirect=true";
	    }
	    
	    
	
	
	
	
	
	
	
	/*********************************CRUD***************************************************/
	    
	  
	   
	 
	    public StreamedContent getFile() {
	        return file;
	    }
	    
	    
	    
	    private static final long serialVersionUID = 1L;
	    
	    /**
	     * Download file.
	     *//*
	    public void downloadFile() throws IOException
	    {
	       File file = new File("C:\\docs\\instructions.txt");
	       InputStream fis = new FileInputStream(file);
	       byte[] buf = new byte[1024];
	       int offset = 0;
	       int numRead = 0;
	       while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) 
	       {
	         offset += numRead;
	       }
	       fis.close();
	       HttpServletResponse response =
	          (HttpServletResponse) FacesContext.getCurrentInstance()
	              .getExternalContext().getResponse();
	      
	      response.setContentType("application/octet-stream");
	      response.setHeader("Content-Disposition", "attachment;filename=instructions.txt");
	      response.getOutputStream().write(buf);
	      response.getOutputStream().flush();
	      response.getOutputStream().close();
	      FacesContext.getCurrentInstance().responseComplete();
	    }*/
	    
	    private DefaultStreamedContent download;

	    public void setDownload(DefaultStreamedContent download) {
	        this.download = download;
	    }

	    public DefaultStreamedContent getDownload() throws Exception {
	        System.out.println("GET = " + download.getName());
	        return download;
	    }

	    public void prepDownload() throws Exception {
	        File file = new File("F:\\dossierMedical.pdf");
	        InputStream input = new FileInputStream(file);
	        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
	        System.out.println("PREP = " + download.getName());
	    }
	  
	

}
