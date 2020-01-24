package com.savitoh.casacodigoapi.payload;

import com.savitoh.casacodigoapi.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class AutorRequest {


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


    public AutorRequest(@NotBlank @Size(max = 50) String nome,
                        @NotBlank @Size(max = 400) String descricao,
                        @Size(max = 256) @Email @NotBlank String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
    }

    public Autor transformaParaEntity() {
        return new Autor(this.nome, this.descricao, this.email);
    }


}
