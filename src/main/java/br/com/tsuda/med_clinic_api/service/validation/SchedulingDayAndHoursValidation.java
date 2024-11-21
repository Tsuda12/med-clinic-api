package br.com.tsuda.med_clinic_api.service.validation;

import br.com.tsuda.med_clinic_api.controller.request.scheduling.SchedulingRequestDTO;
import br.com.tsuda.med_clinic_api.service.exception.SchedulingErrorException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class SchedulingDayAndHoursValidation implements SchedulingValidation{
    @Override
    public void validate(SchedulingRequestDTO request) {
        LocalDateTime dateScheduling = request.date();
        boolean itsSunday = dateScheduling.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean itsBeforeOpening = dateScheduling.getHour() < 7;
        boolean itsAfterClosing = dateScheduling.getHour() > 18;

        if (itsSunday || itsBeforeOpening || itsAfterClosing) {
            throw new SchedulingErrorException("The date or hour is not correct!");
        }
    }
}
