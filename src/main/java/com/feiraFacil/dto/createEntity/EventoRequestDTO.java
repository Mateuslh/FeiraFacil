package com.feiraFacil.dto.createEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Evento;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventoRequestDTO extends AbstractDTO<Evento, EventoRequestDTO> {

    @NotNull
    private LocalDate data;

    public EventoRequestDTO() {
    }

    public EventoRequestDTO(Evento evento) {
        super(evento);
    }
}
