package com.savitoh.casacodigoapi.repository;

import com.savitoh.casacodigoapi.model.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer> {

    boolean existsByTitulo(String titulo);

    boolean existsByIsbn(String isbn);

}
