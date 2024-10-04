package com.feiraFacil.controller;

import com.feiraFacil.dto.FeiranteDTO;
import com.feiraFacil.dto.PaginatedResponseDto;
import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.createEntity.FeiranteCreateDTO;
import com.feiraFacil.model.Feirante;
import com.feiraFacil.services.FeiranteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feirante")
@Tag(name = "Feirante")
public class FeiranteController {

    @Autowired
    FeiranteService feiranteService;

    @GetMapping
    public PaginatedResponseDto<FeiranteDTO> getPage(Pageable pageable) {
        Page<Feirante> feirantesPage = feiranteService.findAll(pageable);
        Page<FeiranteDTO> feiranteDTOPage = feirantesPage.map(feirante -> feiranteService.toFeiranteDTO(feirante));
        return new PaginatedResponseDto<FeiranteDTO>().fromPage(feiranteDTOPage);
    }

    @PostMapping
    public ResponseEntityDto<Feirante> createEntity(@RequestBody FeiranteCreateDTO feiranteCreateDTO) {
        Feirante feirante = feiranteService.toFeirante(feiranteCreateDTO);
        return new ResponseEntityDto<Feirante>().setContent(feiranteService.save(feirante));
    }

    @GetMapping("feirante/{id}")
    public ResponseEntityDto<FeiranteDTO> getEntity(@PathVariable Long id) {
        Feirante feirante = feiranteService.findById(id);
        FeiranteDTO feiranteDTO = feiranteService.toFeiranteDTO(feirante);
        return new ResponseEntityDto<FeiranteDTO>().setContent(feiranteDTO);
    }
}
