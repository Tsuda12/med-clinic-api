package br.com.tsuda.med_clinic_api.controller.request.medic;

import br.com.tsuda.med_clinic_api.controller.request.address.AddressRequestDTO;
import jakarta.validation.constraints.NotNull;

public record MedicUpdateRequestDTO(
        @NotNull
        Long id,
        String name,
        String cellphone,
        AddressRequestDTO address
) {}
