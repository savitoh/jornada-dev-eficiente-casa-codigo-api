package com.savitoh.casacodigoapi.payload;

import com.savitoh.casacodigoapi.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class NovaCategoriaResponse {

    @Size(max = 50)
    @NotBlank
    private final String nome;

    public NovaCategoriaResponse(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public static NovaCategoriaResponse transformaEntityParaDto(Categoria categoria) {
        if(Objects.isNull(categoria)) {
            throw new IllegalArgumentException("Argumento não pode ser nulo");
        }
        return new NovaCategoriaResponse(categoria);
    }

    public String getNome() {
        return nome;
    }
}
