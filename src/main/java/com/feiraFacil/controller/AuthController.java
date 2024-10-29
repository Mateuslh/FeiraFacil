package com.feiraFacil.controller;

import com.feiraFacil.dto.ResponseEntityDto;
import com.feiraFacil.dto.baseEntity.TokenResponseDTO;
import com.feiraFacil.security.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Login")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntityDto<TokenResponseDTO> login(@RequestParam String username, @RequestParam String password) {
        String token = authService.authenticate(username, password);

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
