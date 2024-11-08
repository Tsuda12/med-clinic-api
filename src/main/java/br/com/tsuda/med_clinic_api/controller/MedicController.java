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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medics")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @PostMapping
    @Operation(summary = "Create Medic")
    public MedicResponseDTO create(@RequestBody @Valid MedicRequestDTO request) {
        return medicService.create(request);
    }

    @GetMapping
    @Operation(summary = "Get all Medics")
    public Page<MedicResponseDTO> getAll(@PageableDefault(size = 10, page = 0, sort = {"name"}, direction = Sort.Direction.ASC)
                                         Pageable pagination) {
        return medicService.getAll(pagination);
    }

    @PutMapping
    @Operation(summary = "Update Medic by id")
    public MedicResponseDTO update(@RequestBody @Valid MedicUpdateRequestDTO request) {
        return medicService.update(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Medic by id")
    public void delete(@PathVariable Long id) {
        medicService.delete(id);
    }
}
