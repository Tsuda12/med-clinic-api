package br.com.tsuda.med_clinic_api.controller;

import br.com.tsuda.med_clinic_api.controller.request.MedicRequestDTO;
import br.com.tsuda.med_clinic_api.controller.request.MedicUpdateRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.MedicResponseDTO;
import br.com.tsuda.med_clinic_api.service.MedicService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medics")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @PostMapping
    @Operation(summary = "Create Medic")
    public ResponseEntity<MedicResponseDTO> create(@RequestBody @Valid MedicRequestDTO request, UriComponentsBuilder uriBuilder) {
        MedicResponseDTO response = medicService.create(request);

        var uri = uriBuilder.path("/medics/{id}").buildAndExpand(response.id).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all Medics")
    public ResponseEntity<Page<MedicResponseDTO>> getAll(@PageableDefault(size = 10, page = 0, sort = {"name"}, direction = Sort.Direction.ASC)
                                         Pageable pagination) {
        Page<MedicResponseDTO> response = medicService.getAll(pagination);

        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Operation(summary = "Update Medic by id")
    public ResponseEntity<MedicResponseDTO> update(@RequestBody @Valid MedicUpdateRequestDTO request) {
        MedicResponseDTO response = medicService.update(request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Medic by id")
    public ResponseEntity delete(@PathVariable Long id) {
        medicService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
