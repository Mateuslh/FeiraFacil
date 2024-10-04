package com.feiraFacil.services;

import com.feiraFacil.dto.FeiranteDTO;
import com.feiraFacil.dto.createEntity.FeiranteCreateDTO;
import com.feiraFacil.exception.EntidadeNaoEncontradaException;
import com.feiraFacil.model.Feirante;
import com.feiraFacil.model.Imagem;
import com.feiraFacil.repository.FeiranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class FeiranteService {

    @Autowired
    private FeiranteRepository feiranteRepository;
    @Autowired
    private ImagemService imagemService;
    private MapReactiveUserDetailsService reactiveUserDetailsService;

    public Feirante findById(Long id) {
        return feiranteRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Feirante.class));
    }

    public Feirante save(Feirante feirante) {
        return feiranteRepository.save(feirante);
    }

    public Feirante save(FeiranteCreateDTO feiranteCreateDTO) {
        Feirante feirante = toFeirante(feiranteCreateDTO);
        return save(feirante);
    }

    public Page<Feirante> findAll(Pageable pageable) {
        return feiranteRepository.findAll(pageable);
    }

    public Feirante toFeirante(FeiranteCreateDTO feiranteCreateDTO) {
        Feirante feirante = new Feirante();
        feirante.setNomeFeirante(feiranteCreateDTO.nomeFeirante());
        feirante.setNomeEmpresa(feiranteCreateDTO.nomeEmpresa());
        feirante.setCnpj(feiranteCreateDTO.cnpj());
        feirante.setEmail(feiranteCreateDTO.email());
        feirante.setTelefone(feiranteCreateDTO.telefone());
        Imagem imagem = imagemService.findById(feiranteCreateDTO.feiraId());
        feirante.setImagem(imagem);
        return feirante;
    }

    public FeiranteDTO toFeiranteDTO(Feirante feirante) {
        FeiranteDTO feiranteDTO = new FeiranteDTO(feirante.getId(), feirante.getNomeFeirante(), feirante.getCnpj(), feirante.getTelefone(), feirante.getCategorias(), feirante.getImagemId(), feirante.getEmail(), feirante.getFeira().getId());
        return feiranteDTO;
    }
}
