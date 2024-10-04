package com.feiraFacil.services;

import com.feiraFacil.exception.EntidadeNaoEncontradaException;
import com.feiraFacil.model.Imagem;
import com.feiraFacil.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ImagemService {

    private static final List<String> TIPOS_PERMITIDOS = Arrays.asList("image/jpeg", "image/png", "image/gif");
    @Autowired
    private ImagemRepository imagemRepository;

    public Imagem salvarImagem(MultipartFile file) throws IOException {

        if (!TIPOS_PERMITIDOS.contains(file.getContentType())) {
            throw new IllegalArgumentException("Tipo de arquivo inválido. Permitido apenas imagens (JPEG, PNG, GIF).");
        }

        Imagem imagem = new Imagem();
        imagem.setNome(file.getOriginalFilename());
        imagem.setTipo(file.getContentType());
        imagem.setDados(file.getBytes());

        return imagemRepository.save(imagem);
    }

    public Imagem obterImagem(Long id) {
        return imagemRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(Imagem.class));
    }

    public Imagem findById(Long id) {
        return imagemRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Imagem.class));
    }
}

