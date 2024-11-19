package br.com.tsuda.med_clinic_api.service.interfaces;

import br.com.tsuda.med_clinic_api.controller.request.patient.PatientRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.patient.PatientResponseDTO;

public interface PatientService {

    PatientResponseDTO create(PatientRequestDTO request);
}
