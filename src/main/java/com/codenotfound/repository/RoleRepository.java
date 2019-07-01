package com.codenotfound.repository;


import com.codenotfound.domaine.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Integer> {
	
	public AppRole findByRole(String role);
	public AppRole findById(int id);
}