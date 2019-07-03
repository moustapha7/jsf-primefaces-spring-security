package com.codenotfound.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import com.codenotfound.domaine.AppRole;
import com.codenotfound.domaine.AppUser;
import com.codenotfound.repository.RoleRepository;
import com.codenotfound.repository.UserRepository;



@Named
@SessionScoped
public class UtilisateurController implements Serializable {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private AppUser appUser;
	
	private List<AppUser> appUsers;
	private String message ;
	
	private List<AppRole> appRoles;
	
	
	public UtilisateurController ()
	{
		//initUtilisateur();
		
	}

	@PostConstruct
	private void initUtilisateur() {
		appUser = new AppUser();
		appUser.getRoles();
		getAppUsers();
		getAppRoles();
		
		
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
	
	
	/*public List<AppRole> getAppRoles() {
		
		appRoles = roleRepository.findAll();
		
		 if(appRoles == null) appRoles = new ArrayList<>();
		return appRoles;
	}

	public void setAppRoles(List<AppRole> appRoles) {
		this.appRoles = appRoles;
	}*/
	
	

	
	
	
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
	
	
	public List<AppRole> getAppRoles() {
		return appRoles;
	}

	public void setAppRoles(List<AppRole> appRoles) {
		this.appRoles = appRoles;
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
    
    


	
	
	
	
	
	
	
	/*********************************************************************************************/
	
	
	
	
	
	

}
