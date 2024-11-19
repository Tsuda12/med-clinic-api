package br.com.tsuda.med_clinic_api.controller.response.address;

import br.com.tsuda.med_clinic_api.domain.entity.Address;

public class AddressResponseDTO {

    public String street;
    public String neighborhood;
    public String cep;
    public String complement;
    public String number;
    public String uf;
    public String city;

    public AddressResponseDTO(Address address) {
        this.street = address.getStreet();
        this.neighborhood = address.getNeighborhood();
        this.cep = address.getCep();
        this.complement = address.getComplement();
        this.number = address.getNumber();
        this.uf = address.getUf();
        this.city = address.getCity();
    }
}
