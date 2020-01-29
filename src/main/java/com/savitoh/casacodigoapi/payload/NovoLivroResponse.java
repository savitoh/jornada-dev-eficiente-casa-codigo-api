package com.savitoh.casacodigoapi.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savitoh.casacodigoapi.model.Livro;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NovoLivroResponse {

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroPaginas;

    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataLancamento;

    public NovoLivroResponse(Livro livro) {
        Assert.notNull(livro, "Livro não pode ser nullo");
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }
}
