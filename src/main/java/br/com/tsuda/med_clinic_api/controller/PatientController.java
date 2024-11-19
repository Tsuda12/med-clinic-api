package br.com.tsuda.med_clinic_api.controller;

import br.com.tsuda.med_clinic_api.controller.request.patient.PatientRequestDTO;
import br.com.tsuda.med_clinic_api.controller.request.patient.PatientUpdateRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.patient.PatientResponseDTO;
import br.com.tsuda.med_clinic_api.service.interfaces.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    @Operation(summary = "Get all Patients")
    public ResponseEntity<Page<PatientResponseDTO>> getAll(@PageableDefault(size = 10, page = 0, sort = {"name"},
            direction = Sort.Direction.ASC) Pageable pagination) {
        Page<PatientResponseDTO> response = patientService.getAll(pagination);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Patient by id")
    public ResponseEntity<PatientResponseDTO> getById(@PathVariable Long id) {
        PatientResponseDTO response = patientService.getById(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Patient by id")
    public ResponseEntity<PatientResponseDTO> update(@PathVariable Long id, @RequestBody PatientUpdateRequestDTO request) {
        PatientResponseDTO response = patientService.update(id, request);

        return ResponseEntity.ok(response);
    }
}
