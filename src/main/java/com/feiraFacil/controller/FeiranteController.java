package com.feiraFacil.controller;

import com.feiraFacil.dto.PaginatedResponseDto;
import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.baseEntity.FeiranteBaseDTO;
import com.feiraFacil.dto.createEntity.FeiranteRequestDTO;
import com.feiraFacil.model.Feirante;
import com.feiraFacil.service.FeiranteService;
import com.feiraFacil.utils.PageMapperUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feirantes")
@Tag(name = "Feirante")
public class FeiranteController {

    @Autowired
    FeiranteService feiranteService;

    @GetMapping
    public PaginatedResponseDto<FeiranteBaseDTO> getEntity(Pageable pageable) {
        Page<Feirante> feirantesPage = feiranteService.findAll(pageable);
        Page<FeiranteBaseDTO> feiranteDTOPage = PageMapperUtil.toPageDTO(feirantesPage, FeiranteBaseDTO.class);

        return new PaginatedResponseDto<FeiranteBaseDTO>().fromPage(feiranteDTOPage);
    }

    @PostMapping
    public ResponseEntityDto<FeiranteBaseDTO> createEntity(@RequestBody FeiranteRequestDTO feiranteRequestDTO) {
        Feirante feirante = feiranteRequestDTO.toEntity();
        Feirante feiranteResult = feiranteService.save(feirante);
        FeiranteBaseDTO feiranteBaseDTO = new FeiranteBaseDTO(feiranteResult);

        return new ResponseEntityDto<FeiranteBaseDTO>().setContent(feiranteBaseDTO);
    }

    @GetMapping("feirante/{id}")
    public ResponseEntityDto<FeiranteBaseDTO> getEntity(@PathVariable Long id) {
        Feirante feirante = feiranteService.findById(id);
        FeiranteBaseDTO FeiranteBaseDTO = new FeiranteBaseDTO(feirante);
        return new ResponseEntityDto<FeiranteBaseDTO>().setContent(FeiranteBaseDTO);
    }

    @PutMapping("feirante")
    public ResponseEntityDto<FeiranteBaseDTO> putEntity(@RequestBody FeiranteRequestDTO feiranteRequestDTO) {
        Feirante feirante = feiranteRequestDTO.toEntity();
        Feirante feiranteResult = feiranteService.save(feirante);
        FeiranteBaseDTO feiranteBaseDTO = new FeiranteBaseDTO(feiranteResult);
        return new ResponseEntityDto<FeiranteBaseDTO>().setContent(feiranteBaseDTO);
    }

    @DeleteMapping("feirante/{id}")
    public ResponseEntityDto<Void> deleteEntity(@PathVariable Long id) {
        feiranteService.deleteById(id);
        return new ResponseEntityDto<>();
    }
}
