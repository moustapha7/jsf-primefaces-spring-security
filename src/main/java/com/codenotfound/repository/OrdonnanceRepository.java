package com.codenotfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenotfound.domaine.Ordonnance;


public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {

	Ordonnance findById(int id);

}
