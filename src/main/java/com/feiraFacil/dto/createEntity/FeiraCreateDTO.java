package com.feiraFacil.dto.createEntity;

import java.util.Date;

public record FeiraCreateDTO(String nome, String local, Date data, String descricao, Long imagemId) {
}
