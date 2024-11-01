package com.feiraFacil.service;

import com.feiraFacil.dto.createEntity.FeiranteRequestDTO;
import com.feiraFacil.exception.EntidadeNaoEncontradaException;
import com.feiraFacil.model.Feirante;
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

    public Feirante save(FeiranteRequestDTO feiranteRequestDTO) {
        Feirante feirante = toFeirante(feiranteRequestDTO);
        return save(feirante);
    }

    public Page<Feirante> findAll(Pageable pageable) {
        return feiranteRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        feiranteRepository.delete(findById(id));
    }

    public Feirante toFeirante(FeiranteRequestDTO feiranteRequestDTO) {
        Feirante feirante = new Feirante();
        feirante.setNomeFeirante(feiranteRequestDTO.getNomeFeirante());
        feirante.setNomeEmpresa(feiranteRequestDTO.getNomeEmpresa());
        feirante.setCnpj(feiranteRequestDTO.getCnpj());
        feirante.setEmail(feiranteRequestDTO.getEmail());
        feirante.setTelefone(feiranteRequestDTO.getTelefone());
//        Imagem imagem = imagemService.findById(feiranteRequestDTO.getImagemId());
//        feirante.setImagem(imagem);
        return feirante;
    }
}
