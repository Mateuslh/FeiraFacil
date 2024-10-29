package com.feiraFacil.dto.baseEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Feira;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FeiraBaseDTO extends AbstractDTO<Feira, FeiraBaseDTO> {
    private Long id;
    private String nome;
    private String local;
    private Date data;
    private String descricao;
    private Long imagemId;

    public FeiraBaseDTO() {
    }

    public FeiraBaseDTO(Feira feira) {
        super(feira);
    }

}
