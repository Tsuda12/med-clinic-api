package br.com.tsuda.med_clinic_api.controller.request.patient;

import br.com.tsuda.med_clinic_api.controller.request.address.AddressRequestDTO;

public record PatientUpdateRequestDTO(
        String name,
        String email,
        String cellphone,
        AddressRequestDTO address
) {}
