package br.com.tsuda.med_clinic_api.domain.entity;

import br.com.tsuda.med_clinic_api.controller.request.patient.PatientRequestDTO;
import br.com.tsuda.med_clinic_api.controller.request.patient.PatientUpdateRequestDTO;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String cpf;
    @Embedded
    private Address address;
    private Boolean active;

    public Patient(PatientRequestDTO request) {
        id = getId();
        name = request.name();
        email = request.email();
        cellphone = request.cellphone();
        cpf = request.cpf();
        address = new Address(request.address());
        active = true;
    }

    public void update(PatientUpdateRequestDTO request) {
        if(request.name() != null) {
            this.name = request.name();
        }
        if(request.email() != null) {
            this.email = request.email();
        }
        if(request.cellphone() != null) {
            this.cellphone = request.cellphone();
        }
        if(request.address() != null) {
            this.address.update(request.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
