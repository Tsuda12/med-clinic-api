package br.com.tsuda.med_clinic_api.controller.response;

import br.com.tsuda.med_clinic_api.domain.entity.Medic;
import br.com.tsuda.med_clinic_api.domain.enums.SpecialtyEnum;

public class MedicResponseDTO {

    public Long id;
    public String name;
    public String email;
    public String cellphone;
    public String crm;
    public SpecialtyEnum specialty;
    public AddressResponseDTO address;

    public MedicResponseDTO(Medic medic) {
        this.id = medic.getId();
        this.name = medic.getName();
        this.email = medic.getEmail();
        this.cellphone = medic.getCellphone();
        this.crm = medic.getCrm();
        this.specialty = medic.getSpecialty();
        this.address = new AddressResponseDTO(medic.getAddress());
    }
}
