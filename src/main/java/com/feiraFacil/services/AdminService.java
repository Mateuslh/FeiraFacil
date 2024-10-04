package com.feiraFacil.services;

import com.feiraFacil.dto.createEntity.AdminCreateDTO;
import com.feiraFacil.exception.EntidadeNaoEncontradaException;
import com.feiraFacil.model.Admin;
import com.feiraFacil.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Page<Admin> findAll(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Admin.class));
    }

    public Admin save(Admin admin) {
        admin.setSenha(passwordEncoder.encode(admin.getSenha()));
        return adminRepository.save(admin);
    }

    public void deleteById(Long id) {
        Admin admin = findById(id);
        adminRepository.delete(admin);
    }

    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    public Admin toAdmin(AdminCreateDTO adminCreateDTO) {
        Admin admin = new Admin();
        admin.setUsuario(adminCreateDTO.usuario());
        admin.setSenha(adminCreateDTO.senha());
        admin.setNome(adminCreateDTO.nome());
        admin.setEmail(adminCreateDTO.email());
        admin.setCpf(adminCreateDTO.cpf());
        return admin;
    }
}
