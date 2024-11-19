package br.com.tsuda.med_clinic_api.service.interfaces;

import br.com.tsuda.med_clinic_api.controller.request.medic.MedicRequestDTO;
import br.com.tsuda.med_clinic_api.controller.request.medic.MedicUpdateRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.medic.MedicResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicService {
    MedicResponseDTO create(MedicRequestDTO request);

    Page<MedicResponseDTO> getAll(Pageable pagination);

    MedicResponseDTO getById(Long id);

    MedicResponseDTO update(MedicUpdateRequestDTO requestDTO);

    void delete(Long id);
}
