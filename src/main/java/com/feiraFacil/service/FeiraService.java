package com.feiraFacil.service;

import com.feiraFacil.dto.createEntity.FeiraRequestDTO;
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

    public Feira update(FeiraRequestDTO feiraRequestDTO, Long id) {
        Feira feira = findById(id);
        //feiraMapper.updateEntityFromDto(feiraRequestDTO, feira);
        return save(feira);
    }

    public Feira update(Feira feira) {
        findById(feira.getId());
        return save(feira);
    }

    public void delete(Long id) {
        Feira feira = findById(id);
        feiraRepository.delete(feira);
    }
}

