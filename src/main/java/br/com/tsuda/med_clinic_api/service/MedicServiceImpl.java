package br.com.tsuda.med_clinic_api.service;

import br.com.tsuda.med_clinic_api.controller.request.medic.MedicRequestDTO;
import br.com.tsuda.med_clinic_api.controller.request.medic.MedicUpdateRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.medic.MedicResponseDTO;
import br.com.tsuda.med_clinic_api.domain.entity.Medic;
import br.com.tsuda.med_clinic_api.domain.repository.MedicRepository;
import br.com.tsuda.med_clinic_api.service.interfaces.MedicService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicServiceImpl implements MedicService {

    @Autowired
    private MedicRepository medicRepository;

    @Override
    @Transactional
    public MedicResponseDTO create(MedicRequestDTO request) {
        Medic medic = new Medic(request);
        medicRepository.save(medic);

        return new MedicResponseDTO(medic);
    }

    @Override
    @Transactional
    public Page<MedicResponseDTO> getAll(Pageable pagination) {
        Page<Medic> medics = medicRepository.findAllByActiveTrue(pagination);

        return medics.map(MedicResponseDTO::new);
    }

    @Override
    @Transactional
    public MedicResponseDTO getById(Long id) {
        Medic medic = medicRepository.findByIdAndActiveTrue(id);
        if(medic == null) {
            throw new EntityNotFoundException("Patient with id " + id + " not found!");
        }

        return new MedicResponseDTO(medic);
    }

    @Override
    @Transactional
    public MedicResponseDTO update(MedicUpdateRequestDTO request) {
        Medic medic = medicRepository.findByIdAndActiveTrue(request.id());
        if(medic == null) {
            throw new EntityNotFoundException("Patient with id " + request.id() + " not found!");
        }
        medic.update(request);

        return new MedicResponseDTO(medic);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Medic medic = medicRepository.findByIdAndActiveTrue(id);
        if(medic == null) {
            throw new EntityNotFoundException("Patient with id " + id + " not found!");
        }
        medic.delete();
    }
}
