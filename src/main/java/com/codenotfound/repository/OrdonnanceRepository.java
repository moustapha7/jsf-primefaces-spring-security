package com.codenotfound.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenotfound.domaine.Ordonnance;


public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {

	Optional<Ordonnance> findById(int id);

}
