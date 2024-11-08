package br.com.tsuda.med_clinic_api.service;

import br.com.tsuda.med_clinic_api.controller.request.MedicRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.MedicResponseDTO;
import br.com.tsuda.med_clinic_api.domain.entity.Medic;
import br.com.tsuda.med_clinic_api.domain.repository.MedicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicServiceImpl implements MedicService{

    @Autowired
    private MedicRepository medicRepository;

    @Override
    @Transactional
    public MedicResponseDTO create(MedicRequestDTO request) {
        Medic medic = new Medic(request);
        medicRepository.save(medic);

        return new MedicResponseDTO(medic);
    }
}
