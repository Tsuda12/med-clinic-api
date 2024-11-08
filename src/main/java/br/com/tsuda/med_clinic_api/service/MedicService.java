package br.com.tsuda.med_clinic_api.service;

import br.com.tsuda.med_clinic_api.controller.request.MedicRequestDTO;
import br.com.tsuda.med_clinic_api.controller.request.MedicUpdateRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.MedicResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicService {
    MedicResponseDTO create(MedicRequestDTO request);

    Page<MedicResponseDTO> getAll(Pageable pagination);

    MedicResponseDTO update(MedicUpdateRequestDTO requestDTO);

    void delete(Long id);
}
