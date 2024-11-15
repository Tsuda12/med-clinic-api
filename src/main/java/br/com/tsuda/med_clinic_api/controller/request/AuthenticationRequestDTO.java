package br.com.tsuda.med_clinic_api.controller.request;

public record AuthenticationRequestDTO(
        String login,
        String password
) {}
