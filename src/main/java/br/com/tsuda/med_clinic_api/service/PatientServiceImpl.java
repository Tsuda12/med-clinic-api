package br.com.tsuda.med_clinic_api.service;

import br.com.tsuda.med_clinic_api.controller.request.patient.PatientRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.patient.PatientResponseDTO;
import br.com.tsuda.med_clinic_api.domain.entity.Patient;
import br.com.tsuda.med_clinic_api.domain.repository.PatientRepository;
import br.com.tsuda.med_clinic_api.service.interfaces.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional
    public PatientResponseDTO create(PatientRequestDTO request) {
        Patient patient = new Patient(request);
        patientRepository.save(patient);

        return new PatientResponseDTO(patient);
    }

    @Override
    public Page<PatientResponseDTO> getAll(Pageable pagination) {
        Page<Patient> patients = patientRepository.findAllByActiveTrue(pagination);

        return patients.map(PatientResponseDTO::new);
    }
}
