package com.feiraFacil.controller;

import com.feiraFacil.dto.PaginatedResponseDto;
import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.baseEntity.CategoriaBaseDTO;
import com.feiraFacil.dto.createEntity.CategoriaRequestDTO;
import com.feiraFacil.model.Categoria;
import com.feiraFacil.service.CategoriaService;
import com.feiraFacil.utils.PageMapperUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @Transactional
    @GetMapping
    public PaginatedResponseDto<Categoria> getEntity(Pageable pageable) {
        Page<Categoria> categoriaPage = categoriaService.findAll(pageable);
        Page<CategoriaBaseDTO> categoriaBaseDTOS = PageMapperUtil.toPageDTO(categoriaPage, CategoriaBaseDTO.class);
        return new PaginatedResponseDto<Categoria>().fromPage(categoriaPage);
    }

    @Transactional
    @GetMapping("categoria/{id}")
    public ResponseEntityDto<CategoriaBaseDTO> getEntityById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        CategoriaBaseDTO categoriaBaseDTO = new CategoriaBaseDTO(categoria);
        return new ResponseEntityDto<CategoriaBaseDTO>().setContent(categoriaBaseDTO);
    }

    @Transactional
    @PostMapping
    public ResponseEntityDto<CategoriaBaseDTO> createEntity(@RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoriaRequest = categoriaRequestDTO.toEntity();
        Categoria categoriaResult = categoriaService.save(categoriaRequest);
        CategoriaBaseDTO categoriaBaseDTO = new CategoriaBaseDTO(categoriaResult);
        return new ResponseEntityDto<CategoriaBaseDTO>().setContent(categoriaBaseDTO);
    }

    @Transactional
    @PutMapping
    public ResponseEntityDto<CategoriaBaseDTO> updateEntity(@Valid @RequestBody CategoriaBaseDTO categoriaBaseDTO) {
        Categoria categoria = categoriaBaseDTO.toEntity();
        CategoriaBaseDTO categoriaBaseDTOUpdated = new CategoriaBaseDTO(categoriaService.update(categoria));
        return new ResponseEntityDto<CategoriaBaseDTO>().setContent(categoriaBaseDTOUpdated);
    }

    @Transactional
    @DeleteMapping("/categoria/{id}")
    public ResponseEntityDto<Void> deleteEntity(@PathVariable Long id) {
        categoriaService.delete(id);
        return new ResponseEntityDto<Void>();
    }
}
