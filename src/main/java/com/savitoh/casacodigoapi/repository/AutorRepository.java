package com.savitoh.casacodigoapi.repository;

import com.savitoh.casacodigoapi.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {

    boolean existsByEmail(String email);
}
