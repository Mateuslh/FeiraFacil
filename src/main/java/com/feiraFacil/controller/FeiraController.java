package com.feiraFacil.controller;

import com.feiraFacil.dto.PaginatedResponseDto;
import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.createEntity.FeiraCreateDTO;
import com.feiraFacil.model.Feira;
import com.feiraFacil.services.FeiraService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feiras")
@Tag(name = "Feira")
public class FeiraController {

    @Autowired
    FeiraService feiraService;

    @GetMapping
    public PaginatedResponseDto<Feira> getFeira(Pageable pageable) {
        return new PaginatedResponseDto<Feira>().fromPage(feiraService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntityDto<Feira> createFeira(@RequestBody FeiraCreateDTO feiraCreateDTO) {
        return new ResponseEntityDto<Feira>().setContent(feiraService.save(feiraCreateDTO));
    }

    @GetMapping("feira/{id}")
    public ResponseEntityDto<Feira> getFeiraById(@PathVariable Long id) {
        return new ResponseEntityDto<Feira>().setContent(feiraService.findById(id));
    }
}
