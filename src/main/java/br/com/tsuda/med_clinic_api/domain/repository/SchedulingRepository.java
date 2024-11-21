package br.com.tsuda.med_clinic_api.domain.repository;

import br.com.tsuda.med_clinic_api.domain.entity.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
}
