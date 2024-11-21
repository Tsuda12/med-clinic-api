package br.com.tsuda.med_clinic_api.controller.response.scheduling;

import br.com.tsuda.med_clinic_api.domain.enums.SpecialtyEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SchedulingResponseDTO(
        Long id,
        Long medicId,
        Long patientId,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime date
) {}
