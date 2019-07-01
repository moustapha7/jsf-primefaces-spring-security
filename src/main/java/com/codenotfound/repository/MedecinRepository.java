package com.codenotfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenotfound.domaine.Medecin;


public interface MedecinRepository extends JpaRepository<Medecin, Long>
{
	

}
