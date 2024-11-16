package br.com.tsuda.med_clinic_api.controller;

import br.com.tsuda.med_clinic_api.controller.request.AuthenticationRequestDTO;
import br.com.tsuda.med_clinic_api.domain.entity.User;
import br.com.tsuda.med_clinic_api.controller.response.TokenJWTResponseDTO;
import br.com.tsuda.med_clinic_api.service.TokenServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenServiceImpl tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationRequestDTO request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.login(), request.password());
        Authentication authentication = manager.authenticate(authenticationToken);
        String tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTResponseDTO(tokenJWT));
    }
}
