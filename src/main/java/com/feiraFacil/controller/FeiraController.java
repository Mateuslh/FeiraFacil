package com.feiraFacil.controller;

import com.feiraFacil.dto.PaginatedResponseDto;
import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.baseEntity.AdminResponseDTO;
import com.feiraFacil.dto.baseEntity.EventoBaseDTO;
import com.feiraFacil.dto.baseEntity.FeiraBaseDTO;
import com.feiraFacil.dto.createEntity.EventoRequestDTO;
import com.feiraFacil.dto.createEntity.FeiraRequestDTO;
import com.feiraFacil.model.Admin;
import com.feiraFacil.model.Evento;
import com.feiraFacil.model.Feira;
import com.feiraFacil.service.AdminService;
import com.feiraFacil.service.EventoService;
import com.feiraFacil.service.FeiraService;
import com.feiraFacil.utils.PageMapperUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feiras")
public class FeiraController {

    @Autowired
    FeiraService feiraService;
    @Autowired
    private EventoService eventoService;
    @Autowired
    private AdminService adminService;

    @Tag(name = "Feira")
    @Transactional
    @GetMapping("feira/{id}")
    public ResponseEntityDto<FeiraBaseDTO> getEntityById(@PathVariable Long id) {
        Feira feira = feiraService.findById(id);
        FeiraBaseDTO feiraBaseDTO = new FeiraBaseDTO(feira);
        return new ResponseEntityDto<FeiraBaseDTO>().setContent(feiraBaseDTO);
    }

    @Tag(name = "Feira")
    @Transactional
    @GetMapping
    public PaginatedResponseDto<FeiraBaseDTO> getEntity(Pageable pageable) {
        Page<Feira> feiras = feiraService.findAll(pageable);
        Page<FeiraBaseDTO> feiraBaseDTOS = PageMapperUtil.toPageDTO(feiras, FeiraBaseDTO.class);
        return new PaginatedResponseDto<FeiraBaseDTO>().fromPage(feiraBaseDTOS);
    }

    @Tag(name = "Feira")
    @Transactional
    @PostMapping
    public ResponseEntityDto<FeiraBaseDTO> createEntity(@RequestBody FeiraRequestDTO feiraRequestDTO) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Feira feira = feiraRequestDTO.toEntity();
        Feira feiraResult = feiraService.save(feira);

        feiraService.addAdminToFeira(feiraResult.getId(),
                adminService.findByUsername(username).getId());

        FeiraBaseDTO feiraBaseDTO = new FeiraBaseDTO(feiraResult);
        return new ResponseEntityDto<FeiraBaseDTO>().setContent(feiraBaseDTO);
    }

    @Tag(name = "Feira")
    @Transactional
    @PutMapping("feira")
    public ResponseEntityDto<FeiraBaseDTO> updateEntity(@RequestBody FeiraBaseDTO feiraBaseDTO) {
        Feira feira = feiraBaseDTO.toEntity();
        Feira feiraResult = feiraService.update(feira);
        FeiraBaseDTO feiraBaseDTOResult = new FeiraBaseDTO(feiraResult);
        return new ResponseEntityDto<FeiraBaseDTO>().setContent(feiraBaseDTOResult);
    }

    @Tag(name = "Feira")
    @Transactional
    @DeleteMapping("feira/{id}")
    public ResponseEntityDto<Void> deleteEntity(@PathVariable Long id) {
        feiraService.delete(id);
        return new ResponseEntityDto<>();
    }

    @Tag(name = "FeiraAdmin")
    @Transactional
    @GetMapping("feira/{feiraId}/admins")
    public PaginatedResponseDto<AdminResponseDTO> getAdminsByFeira(@PathVariable Long feiraId, Pageable pageable) {
        Page<Admin> adminsPage = feiraService.findAdminsByFeiraId(feiraId, pageable);
        Page<AdminResponseDTO> adminResponseDTOs = PageMapperUtil.toPageDTO(adminsPage, AdminResponseDTO.class);
        return new PaginatedResponseDto<AdminResponseDTO>().fromPage(adminResponseDTOs);
    }

    @Tag(name = "FeiraAdmin")
    @Transactional
    @PostMapping("feira/{feiraId}/admins/{adminId}")
    public ResponseEntityDto<Void> addAdminToFeira(@PathVariable Long feiraId, @PathVariable Long adminId) {
        feiraService.addAdminToFeira(feiraId, adminId);
        return new ResponseEntityDto<>();
    }

    @Tag(name = "FeiraAdmin")
    @Transactional
    @DeleteMapping("feira/{feiraId}/admins/admin/{adminId}")
    public ResponseEntityDto<Void> removeAdminFromFeira(@PathVariable Long feiraId, @PathVariable Long adminId) {
        feiraService.removeAdminFromFeira(feiraId, adminId);
        return new ResponseEntityDto<>();
    }

    @Tag(name = "FeiraEvento")
    @Transactional
    @GetMapping("/{feiraId}/eventos")
    public PaginatedResponseDto<EventoBaseDTO> getEventosByFeira(@PathVariable Long feiraId, Pageable pageable) {
        Page<Evento> eventosPage = feiraService.findEventosByFeiraId(feiraId, pageable);
        Page<EventoBaseDTO> eventoResponseDTOs = PageMapperUtil.toPageDTO(eventosPage, EventoBaseDTO.class);
        return new PaginatedResponseDto<EventoBaseDTO>().fromPage(eventoResponseDTOs);
    }

    @Tag(name = "FeiraEvento")
    @Transactional
    @PostMapping("/{feiraId}/eventos")
    public ResponseEntityDto<Void> addEventoToFeira(@PathVariable Long feiraId, @RequestBody EventoRequestDTO eventoRequestDTO) {
        Evento evento = new Evento(
                eventoRequestDTO.getData(),
                feiraService.findById(feiraId)
        );
        eventoService.save(evento);
        return new ResponseEntityDto<>();
    }

    @Tag(name = "FeiraEvento")
    @Transactional
    @DeleteMapping("/{feiraId}/eventos/evento/{eventoId}")
    public ResponseEntityDto<Void> removeEventoFromFeira(@PathVariable Long feiraId, @PathVariable Long eventoId) {
        Evento evento = eventoService.findByFeiraIdAndEventoId(feiraId, eventoId);
        eventoService.delete(evento);
        return new ResponseEntityDto<>();
    }

}
