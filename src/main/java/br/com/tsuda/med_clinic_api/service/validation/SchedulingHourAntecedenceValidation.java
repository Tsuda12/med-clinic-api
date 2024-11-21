package br.com.tsuda.med_clinic_api.service.validation;

import br.com.tsuda.med_clinic_api.controller.request.scheduling.SchedulingRequestDTO;
import br.com.tsuda.med_clinic_api.service.exception.SchedulingErrorException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class SchedulingHourAntecedenceValidation implements SchedulingValidation{
    @Override
    public void validate(SchedulingRequestDTO request) {
        LocalDateTime dateScheduling = request.date();
        LocalDateTime now = LocalDateTime.now();
        Long differenceBetweenDateSchedulingAndNow = Duration.between(now, dateScheduling).toMinutes();

        if (differenceBetweenDateSchedulingAndNow < 30) {
            throw new SchedulingErrorException("Scheduling must be done at least 30 minutes of antecedence!");
        }
    }
}
