package com.codenotfound.primefaces;


import com.codenotfound.domaine.AppRole;
import com.codenotfound.domaine.AppUser;

public interface AccountService {
	public AppUser addUser(AppUser u);
	public AppRole addRole(AppRole r);
	public void addRoleToUser(String username, int role);
	public AppUser findUtilisateurByUserName(String username);
	
	

}
