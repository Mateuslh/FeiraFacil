package com.feiraFacil.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Feirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFeirante;
    private String nomeEmpresa;
    private String cnpj;
    private String telefone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "feirante_categoria",
            joinColumns = @JoinColumn(name = "feirante_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imagem_id")
    @JsonProperty("imagemId")
    private Imagem imagem;

    @Email
    @NotBlank(message = "O email não pode estar em branco.")
    @Column(unique = true, nullable = false)
    private String email;


    @ManyToOne
    @JoinColumn(name = "feira_id")
    private Feira feira;

    @JsonProperty("imagemId")
    public Long getImagemId() {
        return imagem != null ? imagem.getId() : null;
    }
}