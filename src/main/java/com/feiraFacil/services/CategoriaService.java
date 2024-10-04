package com.feiraFacil.services;

import com.feiraFacil.dto.createEntity.CategoriaCreateDTO;
import com.feiraFacil.exception.EntidadeNaoEncontradaException;
import com.feiraFacil.model.Categoria;
import com.feiraFacil.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Categoria.class));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        if (findById(categoria.getId()) == null) throw new EntidadeNaoEncontradaException(Categoria.class);
        return categoriaRepository.save(categoria);
    }

    public Page<Categoria> findAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    public Categoria toCategoria(CategoriaCreateDTO categoriaCreateDTO) {
        return new Categoria(categoriaCreateDTO.descricao());
    }

}

