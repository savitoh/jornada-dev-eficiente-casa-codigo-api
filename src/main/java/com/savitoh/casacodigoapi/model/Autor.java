package com.savitoh.casacodigoapi.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table
@SequenceGenerator(name = "autor_seq", sequenceName = "autor_autor_id_seq", allocationSize = 1)
public class Autor  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_seq")
    @Column(name = "autor_id")
    private Integer autorId;

    @Column(length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String nome;

    @Column(length = 400, nullable = false)
    @NotBlank
    @Size(max = 400)
    private String descricao;

    @Column(length = 256, nullable = false, unique = true)
    @NotBlank
    @Size(max = 256)
    @Email
    private String email;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;


    public Autor(@NotBlank @Size(max = 50) String nome,
                 @NotBlank @Size(max = 400) String descricao,
                 @NotBlank @Size(max = 256) @Email String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    public Integer getAutorId() {
        return autorId;
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
