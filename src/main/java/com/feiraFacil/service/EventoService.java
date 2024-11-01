package com.feiraFacil.service;

import com.feiraFacil.exception.EntidadeNaoEncontradaException;
import com.feiraFacil.model.Evento;
import com.feiraFacil.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento findByFeiraIdAndEventoId(Long feiraId, Long eventoId) {
        return eventoRepository.findByFeiraIdAndId(feiraId, eventoId).orElseThrow(() -> new EntidadeNaoEncontradaException(Evento.class));
    }

    public void delete(Evento evento) {
        eventoRepository.delete(evento);
    }
}
