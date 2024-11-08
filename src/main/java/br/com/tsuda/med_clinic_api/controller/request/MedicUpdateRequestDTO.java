package br.com.tsuda.med_clinic_api.controller.request;

import jakarta.validation.constraints.NotNull;

public record MedicUpdateRequestDTO(
        @NotNull
        Long id,
        String name,
        String cellphone,
        AddressRequestDTO address
) {}
