package br.com.tsuda.med_clinic_api.controller.request.medic;

import br.com.tsuda.med_clinic_api.controller.request.address.AddressRequestDTO;
import br.com.tsuda.med_clinic_api.domain.enums.SpecialtyEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cellphone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        SpecialtyEnum specialty,
        @NotNull
        @Valid
        AddressRequestDTO address
) {}
