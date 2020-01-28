package com.savitoh.casacodigoapi.validator;

import com.savitoh.casacodigoapi.payload.NovaCategoriaRequest;
import com.savitoh.casacodigoapi.repository.CategoriaRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NovaCategoriaRequestNomeUnicoValidator implements Validator {

    private final CategoriaRepository categoriaRepository;

    public NovaCategoriaRequestNomeUnicoValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovaCategoriaRequest novaCategoriaRequest = (NovaCategoriaRequest) o;
        if(categoriaRepository.existsByNomeIgnoreCase(novaCategoriaRequest.getNome())) {
            errors.rejectValue("nome", null, "Nome deve ser único. Já existe Categoria com este nome");
        }
    }
}
