package com.savitoh.casacodigoapi.payload;

import com.savitoh.casacodigoapi.model.Categoria;
import org.springframework.util.Assert;

public class CategoriaDetalheResponse {

    private final Integer codigo;

    private final String nome;

    public CategoriaDetalheResponse(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public static CategoriaDetalheResponse of(Categoria categoria) {
        Assert.notNull(categoria, "Categoria não pode ser nula");
        return new CategoriaDetalheResponse(categoria.getCategoriaId(), categoria.getNome());
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
