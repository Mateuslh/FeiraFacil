package com.feiraFacil.dto.baseEntity;

import com.feiraFacil.dto.AbstractDTO;
import com.feiraFacil.model.Evento;
import com.feiraFacil.model.Feira;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventoBaseDTO extends AbstractDTO<Evento, EventoBaseDTO> {
    private Long id;
    private LocalDate data;
    private Feira feira;

    public EventoBaseDTO(Evento evento) {
        super(evento);
    }
}
