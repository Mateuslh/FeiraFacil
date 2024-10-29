package com.feiraFacil.dto.baseEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaBaseDTO extends AbstractDTO<Categoria, CategoriaBaseDTO> {
    private long id;
    private String descricao;

    public CategoriaBaseDTO() {
    }

    public CategoriaBaseDTO(Categoria categoria) {
        super(categoria);
    }
}
