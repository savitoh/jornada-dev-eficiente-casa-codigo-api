package com.savitoh.casacodigoapi.payload;

import com.savitoh.casacodigoapi.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovaCategoriaRequest {

    @Size(max = 50)
    @NotBlank
    private String nome;

    @Deprecated
    public NovaCategoriaRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria transformaParaEntity() {
        return new Categoria(this.nome);
    }
}
