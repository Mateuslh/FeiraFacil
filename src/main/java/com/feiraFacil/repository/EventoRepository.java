package com.feiraFacil.repository;

import com.feiraFacil.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>, PagingAndSortingRepository<Evento, Long> {
    List<Evento> findAllByDataAfter(LocalDateTime data);
}
