package com.savitoh.casacodigoapi.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savitoh.casacodigoapi.model.Categoria;
import com.savitoh.casacodigoapi.model.Livro;
import org.springframework.util.Assert;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NovoLivroRequest {


    @NotBlank
    @Size(max = 250)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Digits(integer=6, fraction=2)
    @DecimalMin("20.00")
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataLancamento;

    @NotNull
    private Integer codigoCategoria;

    @Deprecated
    public NovoLivroRequest() {
    }


    public Livro transformaParaEntity(final Categoria categoria) {
        Assert.notNull(categoria, "Categoria não deve ser nulla");
        return new Livro(this.titulo, this.resumo, this.sumario,
                         this.preco, this.numeroPaginas, this.getIsbn(),
                         this.dataLancamento, categoria);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

}
