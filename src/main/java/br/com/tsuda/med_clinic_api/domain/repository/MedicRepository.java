package br.com.tsuda.med_clinic_api.domain.repository;

import br.com.tsuda.med_clinic_api.domain.entity.Medic;
import br.com.tsuda.med_clinic_api.domain.enums.SpecialtyEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
    Page<Medic> findAllByActiveTrue(Pageable pagination);

    Medic findByIdAndActiveTrue(Long id);

    @Query(value = """
            SELECT m
            FROM medics m
            WHERE m.active = true AND m.specialty = :specialty AND m.id NOT IN(
                SELECT s.medic.id 
                FROM schedulings s
                WHERE s.date = :date
            )
            ORDER BY random()
            LIMIT 1
            """, nativeQuery = true)
    Medic choiceFreeRandomMedic(SpecialtyEnum specialty, LocalDateTime date);
}
