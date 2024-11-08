package br.com.tsuda.med_clinic_api.service;

import br.com.tsuda.med_clinic_api.controller.request.MedicRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.MedicResponseDTO;

public interface MedicService {
    MedicResponseDTO create(MedicRequestDTO request);
}
