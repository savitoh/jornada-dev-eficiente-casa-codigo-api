package com.savitoh.casacodigoapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.savitoh.casacodigoapi.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


public class AutorDto implements Serializable {


    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @Size(max = 256)
    @Email
    @NotBlank
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY, value = "dataCriacao")
    private LocalDateTime createdAt;

    public AutorDto() {
    }

    public AutorDto(@NotBlank @Size(max = 50) String nome,
                    @NotBlank @Size(max = 400) String descricao,
                    @Size(max = 256) @Email @NotBlank String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
    }

    public Autor transformaParaEntity() {
        return new Autor(this.nome, this.descricao, this.email);
    }

    public AutorDto transformaEntityParaDto(Autor autor) {
        if(Objects.isNull(autor)) {
            throw new IllegalArgumentException("Argumento não pode ser nulo");
        }
        AutorDto autorDto = new AutorDto(autor.getNome(), autor.getDescricao(), autor.getDescricao());
        autorDto.createdAt = autor.getCreatedAt();
        return autorDto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
