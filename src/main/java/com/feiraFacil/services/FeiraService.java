package com.feiraFacil.services;

import com.feiraFacil.dto.createEntity.FeiraCreateDTO;
import com.feiraFacil.exception.EntidadeNaoEncontradaException;
import com.feiraFacil.model.Feira;
import com.feiraFacil.repository.FeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FeiraService {

    @Autowired
    private FeiraRepository feiraRepository;
    @Autowired
    private ImagemService imagemService;

    public Feira findById(Long id) {
        return feiraRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Feira.class));
    }

    public Feira save(Feira feira) {
        return feiraRepository.save(feira);
    }

    public Page<Feira> findAll(Pageable pageable) {
        return feiraRepository.findAll(pageable);
    }

    public Feira save(FeiraCreateDTO feiraCreateDTO) {
        Feira feira = new Feira();
        feira.setData(feiraCreateDTO.data());
        feira.setDescricao(feiraCreateDTO.descricao());
        feira.setNome(feiraCreateDTO.nome());
        feira.setImagem(imagemService.findById(feiraCreateDTO.imagemId()));
        feira.setLocal(feiraCreateDTO.local());
        return feiraRepository.save(feira);
    }
}

