package com.codenotfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenotfound.domaine.Patient;




public interface PatientRepository extends JpaRepository<Patient, Long> {

}
