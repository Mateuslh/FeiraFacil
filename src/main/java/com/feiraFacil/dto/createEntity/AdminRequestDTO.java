package com.feiraFacil.dto.createEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Admin;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequestDTO extends AbstractDTO<Admin, AdminRequestDTO> {
    private String nome;
    @Email
    private String email;
    private String cpf;
    private String senha;
    private String usuario;

    public AdminRequestDTO() {
    }

    public AdminRequestDTO(Admin admin) {
        super(admin);
    }
}
