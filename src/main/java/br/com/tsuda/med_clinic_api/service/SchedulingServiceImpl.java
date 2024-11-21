package br.com.tsuda.med_clinic_api.service;

import br.com.tsuda.med_clinic_api.controller.request.scheduling.SchedulingRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.scheduling.SchedulingResponseDTO;
import br.com.tsuda.med_clinic_api.domain.entity.Medic;
import br.com.tsuda.med_clinic_api.domain.entity.Patient;
import br.com.tsuda.med_clinic_api.domain.entity.Scheduling;
import br.com.tsuda.med_clinic_api.domain.repository.MedicRepository;
import br.com.tsuda.med_clinic_api.domain.repository.PatientRepository;
import br.com.tsuda.med_clinic_api.domain.repository.SchedulingRepository;
import br.com.tsuda.med_clinic_api.service.interfaces.SchedulingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulingServiceImpl implements SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;
    @Autowired
    private MedicRepository medicRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public SchedulingResponseDTO create(SchedulingRequestDTO request) throws Exception {
        if (!patientRepository.existsById(request.patientId())) {
            throw new EntityNotFoundException("Patient with id " + request.patientId() + " not found!");
        }
        Patient patient = patientRepository.getReferenceById(request.patientId());

        if (request.medicId() != null && !medicRepository.existsById(request.medicId())) {
            throw new EntityNotFoundException("Medic with id " + request.medicId() + " not found!");
        }
        Medic medic = choiceMedic(request);

        Scheduling scheduling = new Scheduling(null, medic, patient, request.date());

        return null;
    }

    private Medic choiceMedic(SchedulingRequestDTO request) throws Exception {
        if (request.medicId() != null) {
            return medicRepository.getReferenceById(request.medicId());
        }

        if (request.specialty() == null) {
            throw new Exception("Specialty is required when not have medic!");
        }

        return medicRepository.choiceFreeRandomMedic(request.specialty(), request.date());
    }
}
