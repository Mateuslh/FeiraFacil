package com.feiraFacil.dto.createEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequestDTO extends AbstractDTO<Categoria, CategoriaRequestDTO> {
    private String descricao;

    public CategoriaRequestDTO(Categoria categoria) {
        super(categoria);
    }
}
