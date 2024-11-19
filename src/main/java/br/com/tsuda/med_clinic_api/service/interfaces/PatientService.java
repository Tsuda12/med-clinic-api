package br.com.tsuda.med_clinic_api.service.interfaces;

import br.com.tsuda.med_clinic_api.controller.request.patient.PatientRequestDTO;
import br.com.tsuda.med_clinic_api.controller.request.patient.PatientUpdateRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.medic.MedicResponseDTO;
import br.com.tsuda.med_clinic_api.controller.response.patient.PatientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {

    PatientResponseDTO create(PatientRequestDTO request);

    Page<PatientResponseDTO> getAll(Pageable pagination);

    PatientResponseDTO getById(Long id);

    PatientResponseDTO update(Long id, PatientUpdateRequestDTO request);
}
