package com.savitoh.casacodigoapi.payload;

import com.savitoh.casacodigoapi.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class AutorResponse {

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

    public AutorResponse(@NotBlank @Size(max = 50) String nome,
                         @NotBlank @Size(max = 400) String descricao,
                         @Size(max = 256) @Email @NotBlank String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
    }

    public static AutorResponse transformaEntityParaDto(Autor autor) {
        if(Objects.isNull(autor)) {
            throw new IllegalArgumentException("Argumento não pode ser nulo");
        }
        return new AutorResponse(autor.getNome(), autor.getDescricao(), autor.getDescricao());
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
