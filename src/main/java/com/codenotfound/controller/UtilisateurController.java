package com.codenotfound.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.core.Authentication;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.codenotfound.domaine.AppRole;
import com.codenotfound.domaine.AppUser;
import com.codenotfound.repository.RoleRepository;
import com.codenotfound.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;



@Named
@SessionScoped
public class UtilisateurController implements Serializable {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private AppUser appUser;
	
	private List<AppUser> appUsers;
	
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	 
	 private boolean skip;
	 
	 private Integer selectedRole ;

	
	private String message ;
	
	private List<AppRole> appRoles;
	
	 private List<AppRole> selectedRoles;
	
	
	

	@PostConstruct
	private void initUtilisateur() {
		this.appRoles = new ArrayList<>();
		appUser = new AppUser();
		appUser.getRoles();
		getAppUsers();
		getAppRoles();
		
		
	}
	
	 public UtilisateurController() {
	        this.appUser = new AppUser();
	       
	        this.appUser.setRoles(new ArrayList<>());
	        this.selectedRoles = new ArrayList<>();
	      /*  this.postes = new ArrayList<Poste>();
	        this.postes = posteRepository.findAll();*/
	    }


	 public boolean isSkip() {
	        return skip;
	    }

	    public void setSkip(boolean skip) {
	        this.skip = skip;
	    }
	    public String onFlowProcess(FlowEvent event) {
	        if(skip) {
	            skip = false;   //reset in case user goes back
	            return "confirm";
	        }
	        else {
	            return event.getNewStep();
	        }
	    }
	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public List<AppUser> getAppUsers() {
		appUsers = userRepository.findAll();
		
		 if(appUsers == null) appUsers = new ArrayList<>();
		
		return appUsers;
	}

	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public List<AppRole> getAppRoles() {
		
		appRoles = roleRepository.findAll();
		
		 if(appRoles == null) appRoles = new ArrayList<>();
		return appRoles;
	}

	public void setAppRoles(List<AppRole> appRoles) {
		this.appRoles = appRoles;
	}
	
	 public List<AppRole> getSelectedRoles() {
	       
			return selectedRoles;
	    }

	    public void setSelectedRoles(List<AppRole> selectedRoles) {
	        this.selectedRoles = selectedRoles;
	    }

	
	
	
	/**********Crud********************************************************************************/
	
	public String deleteUser(AppUser appUser){
        try {
            userRepository.delete(appUser);
            this.appUser = new AppUser();
            return "appUser?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "appUser";
    }
	
	
	

	public String editUser(AppUser appUser){
        try {
            this.appUser = appUser ;
            return "editUtilisateur?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "editUtilisateur?faces-redirect=true";
    }
	
	
   /* public String detailsLocation(Location location){
        try {
            this.location = location ;
            return "locationdetails?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "locationdetails?faces-redirect=true";
    }*/

    public String updateUser(){
        try {
            userRepository.save(appUser);
            appUser = new AppUser();
            return "appUser?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "appUser?faces-redirect=true";
    }
    
    
    public String addUser() {
        try {
            AppRole ap = (AppRole) roleRepository.findAll();
         
           
           // appUser.setRoles((List<AppRole>) ap);
            userRepository.save(appUser);
            
     
            System.out.println("Success!!!");
            appUser =new AppUser();
            return "appUser?faces-redirect=true";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "appUser?error=1&faces-redirect=true";
    }
    
    
    
    
    
    public void save() {
        try{
           
           selectedRoles.forEach(r->{
        	   appUser.getRoles().add(r);
           });

            String hpws = passwordEncoder.encode(appUser.getPassword()) ;
            appUser.setPassword(hpws);

            appUser = userRepository.save(appUser);
            if(appUser != null){
                FacesMessage msg = new FacesMessage("Successful", "Utilisateur ajoute avec succes");
                FacesContext.getCurrentInstance().addMessage(null, msg);
              //  this.user = new AppUser();
            }else{
                FacesMessage msg1 = new FacesMessage("Successful", "Erreur insertion :");
                FacesContext.getCurrentInstance().addMessage(null, msg1);
             //   this.user = new AppUser();
            }

        }catch (Exception ex){
           // this.user = new AppUser();
            System.out.println(ex.getStackTrace());
        }


    }
    
    
    
    
    
    public boolean haveRoles(){
        List<String> lrole = new ArrayList<>();
        lrole.add("ADMIN");
        lrole.add("USER");
        lrole.add("MEDECIN");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
          if(auth.getAuthorities().containsAll(lrole)) {
              return true ;
          }
        }
        return false ;
    }

    
    public boolean haveRoless(String r){

        int isok=0;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
          //  Set<GrantedAuthority> roles = auth.getAuthorities();
        if(auth.getAuthorities().stream().anyMatch(role->((GrantedAuthority) role).getAuthority().equals(r))){
            return true ;
        }

        }
        return false ;
    }

	
	
	
	
	
	
	
	/*********************************************************************************************/
	
	public boolean isMedecin()
	{
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if (auth!=null)
		 {
			if( auth.getAuthorities().contains("MEDECIN"))
			{
				return true;
			}
		 }
		return false;
		
	}
	
	
	
	

}
