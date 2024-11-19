package br.com.tsuda.med_clinic_api.controller;

import br.com.tsuda.med_clinic_api.controller.request.patient.PatientRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.patient.PatientResponseDTO;
import br.com.tsuda.med_clinic_api.service.interfaces.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @Operation(summary = "Create Patient")
    public ResponseEntity<PatientResponseDTO> create(@RequestBody @Valid PatientRequestDTO request, UriComponentsBuilder uriBuilder) {
        PatientResponseDTO response = patientService.create(request);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(response.id).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
