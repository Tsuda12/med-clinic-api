package br.com.tsuda.med_clinic_api.service.validation;

import br.com.tsuda.med_clinic_api.controller.request.scheduling.SchedulingRequestDTO;

public interface SchedulingValidation {

    void validate(SchedulingRequestDTO request);
}
