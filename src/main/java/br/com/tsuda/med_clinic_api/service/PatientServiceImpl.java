package br.com.tsuda.med_clinic_api.service;

import br.com.tsuda.med_clinic_api.controller.request.patient.PatientRequestDTO;
import br.com.tsuda.med_clinic_api.controller.request.patient.PatientUpdateRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.patient.PatientResponseDTO;
import br.com.tsuda.med_clinic_api.domain.entity.Patient;
import br.com.tsuda.med_clinic_api.domain.repository.PatientRepository;
import br.com.tsuda.med_clinic_api.service.interfaces.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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
    @Transactional
    public Page<PatientResponseDTO> getAll(Pageable pagination) {
        Page<Patient> patients = patientRepository.findAllByActiveTrue(pagination);

        return patients.map(PatientResponseDTO::new);
    }

    @Override
    @Transactional
    public PatientResponseDTO getById(Long id) {
        Patient patient = patientRepository.findByIdAndActiveTrue(id);
        if(patient == null) {
            throw new EntityNotFoundException("Patient with id " + id + " not found!");
        }

        return new PatientResponseDTO(patient);
    }

    @Override
    @Transactional
    public PatientResponseDTO update(Long id, PatientUpdateRequestDTO request) {
        Patient patient = patientRepository.findByIdAndActiveTrue(id);
        if(patient == null) {
            throw new EntityNotFoundException("Patient with id " + id + " not found!");
        }
        patient.update(request);

        return new PatientResponseDTO(patient);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Patient patient = patientRepository.findByIdAndActiveTrue(id);
        if(patient == null) {
            throw new EntityNotFoundException("Patient with id " + id + " not found!");
        }
        patient.delete();
    }
}
