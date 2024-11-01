package com.feiraFacil.controller;

import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.baseEntity.ImagemResponseDTO;
import com.feiraFacil.model.Imagem;
import com.feiraFacil.service.ImagemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/imagens")
@Tag(name = "Imagem")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

    @Transactional
    @PostMapping("/upload")
    public ResponseEntityDto<ImagemResponseDTO> uploadImagem(@RequestParam("file") MultipartFile file) throws IOException {
        Imagem imagem = imagemService.salvarImagem(file);
        return new ResponseEntityDto<>().setContent(new ImagemResponseDTO(imagem));

    }

    @Transactional
    @GetMapping("/imagem/{id}")
    public ResponseEntity<byte[]> downloadImagem(@PathVariable Long id) {
        Imagem imagem = imagemService.obterImagem(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imagem.getTipo()))
                .body(imagem.getDados());
    }

    @Transactional
    @DeleteMapping("/imagem/{id}")
    public ResponseEntityDto<Void> delete(@PathVariable Long id) {
        imagemService.excluir(id);
        return new ResponseEntityDto<>();
    }
}
