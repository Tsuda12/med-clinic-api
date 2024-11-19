package br.com.tsuda.med_clinic_api.controller.request.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRequestDTO(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        String complement,
        String number,
        @NotBlank
        String uf,
        @NotBlank
        String city
) {}
