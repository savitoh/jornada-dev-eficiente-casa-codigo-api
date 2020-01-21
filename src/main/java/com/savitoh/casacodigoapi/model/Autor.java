package com.savitoh.casacodigoapi.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "autor")
@SequenceGenerator(name = "autor_seq", sequenceName = "autor_autor_id_seq", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_seq")
    @Column(name = "autor_id")
    private Integer autorId;

    @Column(name = "nome", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String nome;

    @Column(name = "descricao", length = 400, nullable = false)
    @NotBlank
    @Size(max = 400)
    private String descricao;

    @Column(name = "email", length = 256, nullable = false)
    @NotBlank
    @Size(max = 256)
    @Email
    private String emaill;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(autorId, autor.autorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autorId);
    }
}
