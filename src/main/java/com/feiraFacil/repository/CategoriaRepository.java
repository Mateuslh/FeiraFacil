package com.feiraFacil.repository;

import com.feiraFacil.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>, PagingAndSortingRepository<Categoria, Long> {
}
