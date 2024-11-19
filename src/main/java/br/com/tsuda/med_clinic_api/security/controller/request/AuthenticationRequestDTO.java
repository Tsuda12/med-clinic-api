package br.com.tsuda.med_clinic_api.security.controller.request;

public record AuthenticationRequestDTO(
        String login,
        String password
) {}
