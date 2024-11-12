package br.com.tsuda.med_clinic_api.controller.response;

public record ArgumentNotValidResponseDTO (
        String field,
        String message
) {}
