package com.feiraFacil.dto.baseEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Admin;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminResponseDTO extends AbstractDTO<Admin, AdminResponseDTO> {
    private String nome;
    @Email
    private String email;
    private String cpf;
    private String usuario;

    public AdminResponseDTO() {
    }

    public AdminResponseDTO(Admin admin) {
        super(admin);
    }
}
