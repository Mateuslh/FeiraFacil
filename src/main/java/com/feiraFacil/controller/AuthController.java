package com.feiraFacil.controller;

import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.baseEntity.TokenResponseDTO;
import com.feiraFacil.dto.createEntity.LoginRequestDTO;
import com.feiraFacil.security.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Login")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Transactional
    @PostMapping("/login")
    public ResponseEntityDto<TokenResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        String token = authService.authenticate(loginRequestDTO.getUsuario(), loginRequestDTO.getSenha());

        if (token != null) {
            return new ResponseEntityDto<>().setContent(new TokenResponseDTO(token));
        } else {
            ResponseEntityDto responseEntityDto = new ResponseEntityDto<>();
            responseEntityDto.setSuccess(Boolean.FALSE);
            responseEntityDto.setMessage("Usuario ou senha incorreto.");
            return responseEntityDto;
        }
    }
}
