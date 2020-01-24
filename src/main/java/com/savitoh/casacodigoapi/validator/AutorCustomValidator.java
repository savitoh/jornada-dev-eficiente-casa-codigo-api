package com.savitoh.casacodigoapi.validator;

import com.savitoh.casacodigoapi.exception.data.CreateAutorValidateException;
import com.savitoh.casacodigoapi.model.Autor;
import com.savitoh.casacodigoapi.repository.AutorRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AutorCustomValidator  {

    private final AutorRepository autorRepository;

    public AutorCustomValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void validate(Autor autor) {

        if(Objects.isNull(autor)) {
            throw  new IllegalArgumentException("Autor não pode ser nulo");
        }

        if(autorRepository.existsByEmail(autor.getEmail())) {
            throw new CreateAutorValidateException("Email deve ser único. Já Existe Autor cadastro com este email");
        }
    }

}
