package com.feiraFacil.dto.createEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Feirante;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeiranteRequestDTO extends AbstractDTO<Feirante, FeiranteRequestDTO> {
    private String nomeFeirante;
    private String nomeEmpresa;
    private String cnpj;
    private String telefone;
    //    private Long imagemId;
    private String email;
    private Long feiraId;

    public FeiranteRequestDTO() {
    }

    public FeiranteRequestDTO(Feirante feirante) {
        super(feirante);
    }
}
