package com.feiraFacil.dto.createEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Admin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequestDTO extends AbstractDTO<Admin, AdminRequestDTO> {
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private String usuario;

    public AdminRequestDTO(Admin admin) {
        super(admin);
    }
}
