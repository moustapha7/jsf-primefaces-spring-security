package com.codenotfound.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import com.codenotfound.domaine.AppRole;
import com.codenotfound.domaine.AppUser;
import com.codenotfound.repository.RoleRepository;
import com.codenotfound.repository.UserRepository;




public class UtilisateurController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private AppUser appUser;
	
	private List<AppUser> appUsers;
	private String message ;
	
	public UtilisateurController ()
	{
		initUtilisateur();
		
	}

	private void initUtilisateur() {
		appUser = new AppUser();
		appUser.getRoles();
		
		
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public List<AppUser> getAppUsers() {
		appUsers = userRepository.findAll();
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
         
           
            appUser.setRoles((List<AppRole>) ap);
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
