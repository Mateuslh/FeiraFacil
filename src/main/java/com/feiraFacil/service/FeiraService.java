package com.feiraFacil.service;

import com.feiraFacil.exception.EntidadeNaoEncontradaException;
import com.feiraFacil.model.Admin;
import com.feiraFacil.model.Evento;
import com.feiraFacil.model.Feira;
import com.feiraFacil.repository.AdminRepository;
import com.feiraFacil.repository.EventoRepository;
import com.feiraFacil.repository.FeiraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FeiraService {

    @Autowired
    private FeiraRepository feiraRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ImagemService imagemService;
    @Autowired
    private EventoRepository eventoRepository;

    public Feira findById(Long id) {
        return feiraRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(Feira.class));
    }

    public Feira save(Feira feira) {
        return feiraRepository.save(feira);
    }

    public Page<Feira> findAll(Pageable pageable) {
        return feiraRepository.findAll(pageable);
    }

    public Feira update(Feira feira) {
        findById(feira.getId());
        return save(feira);
    }

    public void delete(Long id) {
        Feira feira = findById(id);
        feiraRepository.delete(feira);
    }

    public Page<Admin> findAdminsByFeiraId(Long feiraId, Pageable pageable) {
        Feira feira = feiraRepository.findById(feiraId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(Feira.class));
        return new PageImpl<>(feira.getAdmins(), pageable, feira.getAdmins().size());
    }

    @Transactional
    public void addAdminToFeira(Long feiraId, Long adminId) {
        Feira feira = feiraRepository.findById(feiraId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(Feira.class));
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(Admin.class));

        feira.getAdmins().add(admin);
        feiraRepository.save(feira);
    }

    @Transactional
    public void removeAdminFromFeira(Long feiraId, Long adminId) {
        Feira feira = feiraRepository.findById(feiraId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(Feira.class));
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(Feira.class));

        feira.getAdmins().remove(admin);
        feiraRepository.save(feira);
    }

    public Page<Evento> findEventosByFeiraId(Long feiraId, Pageable pageable) {
        Feira feira = feiraRepository.findById(feiraId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(Feira.class));
        return new PageImpl<>(feira.getEventos(), pageable, feira.getAdmins().size());
    }

}

