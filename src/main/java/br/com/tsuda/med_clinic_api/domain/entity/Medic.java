package br.com.tsuda.med_clinic_api.domain.entity;

import br.com.tsuda.med_clinic_api.controller.request.MedicRequestDTO;
import br.com.tsuda.med_clinic_api.domain.enums.SpecialtyEnum;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medics")
@Entity(name = "Medic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private SpecialtyEnum specialty;
    @Embedded
    private Address address;
    private Boolean active;

    public Medic(MedicRequestDTO request) {
        this.id = getId();
        this.name = request.name();
        this.email = request.email();
        this.cellphone = request.cellphone();
        this.crm = request.crm();
        this.specialty = request.specialty();
        this.address = new Address(request.address());
        this.active = true;
    }

//    public void update(MedicUpdateRequestDTO request) {
//        if(request.name() != null) {
//          this.name = request.name();
//        }
//        if(request.cellphone() != null) {
//            this.cellphone = request.cellphone();
//        }
//        if(request.address() != null) {
//            this.address.update(request.address());
//        }
//    }

    public void delete() {
        this.active = false;
    }
}
