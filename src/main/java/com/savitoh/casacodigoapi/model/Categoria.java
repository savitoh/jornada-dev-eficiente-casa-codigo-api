package com.savitoh.casacodigoapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
@SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_categoria_id_seq", allocationSize = 1)
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_seq")
    @Column(name = "categoria_id")
    private Integer categoriaId;

    @Column(unique = true)
    @Size(max = 50)
    @NotBlank
    private String nome;

    public Categoria() {
    }

    public Categoria(@Size(max = 50) @NotBlank String nome) {
        this.nome = nome;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
