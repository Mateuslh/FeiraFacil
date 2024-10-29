package com.feiraFacil.dto.createEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Feira;
import com.feiraFacil.model.Imagem;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FeiraRequestDTO extends AbstractDTO<Feira, FeiraRequestDTO> {
    private Long id;
    private String nome;
    private String local;
    private Date data;
    private String descricao;
    @JsonProperty("imagemId")
    private Imagem imagem;

    public FeiraRequestDTO() {
    }

    public FeiraRequestDTO(Feira feira) {
        super(feira);
    }
}
