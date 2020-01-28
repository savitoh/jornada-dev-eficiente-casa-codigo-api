package com.savitoh.casacodigoapi.repository;

import com.savitoh.casacodigoapi.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

    boolean existsByNomeIgnoreCase(String nome);

}
