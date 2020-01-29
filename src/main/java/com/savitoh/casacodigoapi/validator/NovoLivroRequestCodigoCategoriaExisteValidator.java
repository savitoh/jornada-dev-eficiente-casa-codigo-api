package com.savitoh.casacodigoapi.validator;

import com.savitoh.casacodigoapi.payload.NovoLivroRequest;
import com.savitoh.casacodigoapi.repository.CategoriaRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NovoLivroRequestCodigoCategoriaExisteValidator implements Validator {

    private final CategoriaRepository categoriaRepository;

    public NovoLivroRequestCodigoCategoriaExisteValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovoLivroRequest novoLivroRequest = (NovoLivroRequest) o;
        if(!categoriaRepository.existsById(novoLivroRequest.getCodigoCategoria())) {
            errors.rejectValue("codigoCategoria", null, "O Código da categoria não foi encontrado");
        }
    }
}
