package br.com.tsuda.med_clinic_api.service.exception;

public class SchedulingErrorException extends RuntimeException {

    public SchedulingErrorException(String message) {
        super(message);
    }
}
