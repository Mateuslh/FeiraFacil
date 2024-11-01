package com.feiraFacil.dto.baseEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Feirante;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeiranteBaseDTO extends AbstractDTO<Feirante, FeiranteBaseDTO> {
    private Long id;
    private String nomeFeirante;
    private String nomeEmpresa;
    private String cnpj;
    private String telefone;
    //    private Long imagemId;
    private String email;
    private Long feiraId;

    public FeiranteBaseDTO() {
    }

    public FeiranteBaseDTO(Feirante feirante) {
        super(feirante);
    }
}
