package com.savitoh.casacodigoapi.payload;

import com.savitoh.casacodigoapi.model.Categoria;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovaCategoriaResponse {

    @Size(max = 50)
    @NotBlank
    private final String nome;

    public NovaCategoriaResponse(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public static NovaCategoriaResponse transformaEntityParaDto(Categoria categoria) {
        Assert.notNull(categoria, "Categoria não pode ser nula");
        return new NovaCategoriaResponse(categoria);
    }

    public String getNome() {
        return nome;
    }
}
