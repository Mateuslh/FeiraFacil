package com.feiraFacil.dto;

import com.feiraFacil.model.Categoria;

import java.util.List;

public record FeiranteDTO(Long id, String nomeFeirante, String cnpj, String telefone, List<Categoria> categorias,
                          Long imagemId, String email, Long feiraId) {
}
