package br.com.tsuda.med_clinic_api.controller.handler.response;

public record ArgumentNotValidResponseDTO (
        String field,
        String message
) {}
