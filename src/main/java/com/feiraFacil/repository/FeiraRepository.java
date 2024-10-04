package com.feiraFacil.repository;

import com.feiraFacil.model.Feira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeiraRepository extends JpaRepository<Feira, Long>, PagingAndSortingRepository<Feira, Long> {
}
