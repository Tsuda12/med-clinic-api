package br.com.tsuda.med_clinic_api.service.interfaces;

import br.com.tsuda.med_clinic_api.controller.request.scheduling.SchedulingRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.scheduling.SchedulingResponseDTO;

public interface SchedulingService {

    void create(SchedulingRequestDTO request) throws Exception;
}
