package com.savitoh.casacodigoapi.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@SequenceGenerator(name = "livro_seq", sequenceName = "livro_livro_id_seq", allocationSize = 1)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_seq")
    @Column(name = "livro_id")
    private Integer livroId;

    @Column(unique = true, length = 250)
    @NotBlank
    @Size(max = 250)
    private String titulo;

    @Column(length = 500)
    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Lob
    private String sumario;

    @Column(precision = 6, scale = 2)
    @NotNull
    @Digits(integer=6, fraction=2)
    @DecimalMin("20.00")
    private BigDecimal preco;

    @Column(name = "numero_paginas")
    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @Column(length = 17, unique = true)
    @NotBlank
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
    private String isbn;

    @Column(name = "data_lancamento", columnDefinition = "TIMESTAMP")

    @Future
    @NotNull
    private LocalDateTime dataLancamento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id")
    @NotNull
    private Categoria categoria;

    /**
     * @deprecated (Usado apenas pelo Hibernate)
     */
    @Deprecated(since = "always")
    public Livro() {
    }

    public Livro(@NotBlank @Size(max = 250) String titulo,
                 @NotBlank @Size(max = 500) String resumo,
                 String sumario,
                 @NotNull @Digits(integer = 6, fraction = 2) @DecimalMin("20.00") BigDecimal preco,
                 @NotNull @Min(100) Integer numeroPaginas,
                 @NotBlank @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$") String isbn,
                 @Future LocalDateTime dataLancamento,
                 @NotNull Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }
}
