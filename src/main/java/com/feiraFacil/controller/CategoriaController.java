package com.feiraFacil.controller;

import com.feiraFacil.dto.PaginatedResponseDto;
import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.createEntity.CategoriaCreateDTO;
import com.feiraFacil.model.Categoria;
import com.feiraFacil.services.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public PaginatedResponseDto<Categoria> getCategoria(Pageable pageable) {
        return new PaginatedResponseDto<Categoria>().fromPage(categoriaService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntityDto<Categoria> createFeira(@RequestBody CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria = categoriaService.toCategoria(categoriaCreateDTO);
        return new ResponseEntityDto<Categoria>().setContent(categoriaService.save(categoria));
    }

    @GetMapping("categoria/{id}")
    public ResponseEntityDto<Categoria> getFeiraById(@PathVariable Long id) {
        return new ResponseEntityDto<Categoria>().setContent(categoriaService.findById(id));
    }

    @PutMapping
    public ResponseEntityDto<Categoria> updateEntity(@Valid @RequestBody Categoria categoria) {
        return new ResponseEntityDto<Categoria>().setContent(categoriaService.update(categoria));
    }
}
