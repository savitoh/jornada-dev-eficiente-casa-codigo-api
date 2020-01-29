package com.savitoh.casacodigoapi.repository;

import com.savitoh.casacodigoapi.model.Livro;
import com.savitoh.casacodigoapi.payload.LivroProjecaoCompactaResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer> {

    boolean existsByTitulo(String titulo);

    boolean existsByIsbn(String isbn);

    @Query(value = "SELECT " +
                        "new com.savitoh.casacodigoapi.payload.LivroProjecaoCompactaResponse(livro.livroId, livro.titulo) " +
                    "FROM " +
                        "Livro livro ")
    List<LivroProjecaoCompactaResponse> obtemTodosLivrosProjetados();

}
