package br.com.tsuda.med_clinic_api.domain.entity;

import br.com.tsuda.med_clinic_api.controller.request.AddressRequestDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String cep;
    private String complement;
    private String number;
    private String uf;
    private String city;

    public Address(AddressRequestDTO request) {
        this.street = request.street();
        this.neighborhood = request.neighborhood();
        this.cep = request.cep();
        this.complement = request.complement();
        this.number = request.number();
        this.uf = request.uf();
        this.city = request.city();
    }

    public void update(AddressRequestDTO request) {
        if(request.street() != null) {
            this.street = request.street();
        }
        if(request.neighborhood() != null) {
            this.neighborhood = request.neighborhood();
        }
        if(request.cep() != null) {
            this.cep = request.cep();
        }
        if(request.complement() != null) {
            this.complement = request.complement();
        }
        if(request.number() != null) {
            this.number = request.number();
        }
        if(request.uf() != null) {
            this.uf = request.uf();
        }
        if(request.city() != null) {
            this.city = request.city();
        }
    }
}
