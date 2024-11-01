package com.feiraFacil.dto.createEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Feira;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//@Component
public class FeiraRequestDTO extends AbstractDTO<Feira, FeiraRequestDTO> {
    private String nome;
    private String local;
    private Date data;
    private String descricao;
//    @JsonProperty("imagemId")
//    private Long imagem;

//    @Autowired
//    private ImagemService imagemService;
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    public FeiraRequestDTO(ImagemService imagemService,ModelMapper modelMapper){
//        this.imagemService = imagemService;
//        this.modelMapper = modelMapper;
//    }

    public FeiraRequestDTO() {
    }

    public FeiraRequestDTO(Feira feira) {
        super(feira);
    }

//    @Override
//    public Feira toEntity() {
//        Feira feira = modelMapper.map(this, Feira.class);
//        feira.setImagem(imagemService.findById(imagem));
//        return feira;
//    }
}
