package com.feiraFacil.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Feira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String local;
    private String descricao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imagem_id")
    @JsonProperty("imagemId")
    private Imagem imagem;

    @OneToMany(mappedBy = "feira", fetch = FetchType.LAZY)
    private List<Feirante> feirantes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "feira_admin",
            joinColumns = @JoinColumn(name = "feira_id"),
            inverseJoinColumns = @JoinColumn(name = "admin_id")
    )
    private List<Admin> admins;

    @OneToMany(mappedBy = "feira", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Evento> eventos;

    @JsonProperty("imagemId")
    public Long getImagemId() {
        return imagem != null ? imagem.getId() : null;
    }
}
