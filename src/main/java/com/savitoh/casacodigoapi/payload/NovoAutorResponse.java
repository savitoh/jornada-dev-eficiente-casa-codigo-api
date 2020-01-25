package com.savitoh.casacodigoapi.payload;

import com.savitoh.casacodigoapi.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class NovoAutorResponse {

    @NotBlank
    @Size(max = 50)
    private final String nome;

    @NotBlank
    @Size(max = 400)
    private final String descricao;

    @Size(max = 256)
    @Email
    @NotBlank
    private final String email;

    public NovoAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
        this.email = autor.getEmail();
    }

    public static NovoAutorResponse transformaEntityParaDto(Autor autor) {
        if(Objects.isNull(autor)) {
            throw new IllegalArgumentException("Argumento não pode ser nulo");
        }
        return new NovoAutorResponse(autor);
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
}
