package com.savitoh.casacodigoapi.payload;

public class LivroProjecaoCompactaResponse {

    private Integer livroCodigo;

    private String titulo;

    public LivroProjecaoCompactaResponse(Integer livroCodigo, String titulo) {
        this.livroCodigo = livroCodigo;
        this.titulo = titulo;
    }

    public Integer getLivroCodigo() {
        return livroCodigo;
    }

    public String getTitulo() {
        return titulo;
    }
}
