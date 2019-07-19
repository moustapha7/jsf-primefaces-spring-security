package com.codenotfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenotfound.domaine.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
	

}
