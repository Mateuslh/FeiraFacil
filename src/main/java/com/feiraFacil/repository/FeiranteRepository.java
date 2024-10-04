package com.feiraFacil.repository;

import com.feiraFacil.model.Feirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeiranteRepository extends JpaRepository<Feirante, Long>, PagingAndSortingRepository<Feirante, Long> {
}
