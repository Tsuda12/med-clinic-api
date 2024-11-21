package br.com.tsuda.med_clinic_api.controller.request.scheduling;

import br.com.tsuda.med_clinic_api.domain.enums.SpecialtyEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SchedulingRequestDTO(
        Long medicId,
        SpecialtyEnum specialty,
        @NotNull
        Long patientId,
        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime date
) {}
