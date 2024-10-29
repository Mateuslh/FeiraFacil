package com.feiraFacil.dto.baseEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Imagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImagemResponseDTO extends AbstractDTO<Imagem, ImagemResponseDTO> {
    private Long id;

    public ImagemResponseDTO() {
    }

    public ImagemResponseDTO(Imagem imagem) {
        super(imagem);
    }
}
