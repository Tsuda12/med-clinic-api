package br.com.tsuda.med_clinic_api.controller;

import br.com.tsuda.med_clinic_api.controller.request.scheduling.SchedulingRequestDTO;
import br.com.tsuda.med_clinic_api.controller.response.scheduling.SchedulingResponseDTO;
import br.com.tsuda.med_clinic_api.service.interfaces.SchedulingService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @PostMapping
    @Operation(summary = "Create Scheduling")
    public void create(@RequestBody @Valid SchedulingRequestDTO request) throws Exception {
       schedulingService.create(request);
    }
}
