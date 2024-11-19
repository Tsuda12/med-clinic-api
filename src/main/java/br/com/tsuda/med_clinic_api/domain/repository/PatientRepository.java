package br.com.tsuda.med_clinic_api.domain.repository;

import br.com.tsuda.med_clinic_api.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
