package br.com.tsuda.med_clinic_api.controller;

import br.com.tsuda.med_clinic_api.controller.request.MedicRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.MedicResponseDTO;
import br.com.tsuda.med_clinic_api.service.MedicService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
