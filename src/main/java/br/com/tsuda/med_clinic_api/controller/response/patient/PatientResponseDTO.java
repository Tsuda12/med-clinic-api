package br.com.tsuda.med_clinic_api.controller.response.patient;

import br.com.tsuda.med_clinic_api.controller.response.address.AddressResponseDTO;
import br.com.tsuda.med_clinic_api.domain.entity.Patient;

public class PatientResponseDTO {

    public Long id;
    public String name;
    public String email;
    public String cellphone;
    public String cpf;
    public AddressResponseDTO address;

    public PatientResponseDTO(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.email = patient.getEmail();
        this.cellphone = patient.getCellphone();
        this.cpf = patient.getCpf();
        this.address = new AddressResponseDTO(patient.getAddress());
    }
}
