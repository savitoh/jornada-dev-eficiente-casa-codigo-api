package com.savitoh.casacodigoapi.service;

import com.savitoh.casacodigoapi.model.Autor;
import com.savitoh.casacodigoapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class AutorService implements GenericService<Autor, Integer> {

    private final AutorRepository autorRepository;

    public AutorService(@Autowired AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor save(Autor object) {
        return autorRepository.save(object);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Autor> getById(Integer id) {
        return autorRepository.findById(id);
    }

    @Override
    public void delete(Autor object) {
        autorRepository.delete(object);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Autor> getAll() {
        return Collections.emptyList();
    }
}
