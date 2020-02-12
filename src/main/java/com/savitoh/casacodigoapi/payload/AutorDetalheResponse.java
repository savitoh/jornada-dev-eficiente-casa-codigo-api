package com.savitoh.casacodigoapi.payload;

import com.savitoh.casacodigoapi.model.Autor;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDetalheResponse {

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

    public AutorDetalheResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
        this.email = autor.getEmail();
    }

    public static AutorDetalheResponse transformaEntityParaDto(Autor autor) {
        Assert.notNull(autor, "Autor não pode ser nulo");
        return new AutorDetalheResponse(autor);
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
