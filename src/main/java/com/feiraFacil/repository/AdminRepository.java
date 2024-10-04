package com.feiraFacil.repository;

import com.feiraFacil.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>, PagingAndSortingRepository<Admin, Long> {
    Optional<Admin> findByUsuario(String usuario);
}
