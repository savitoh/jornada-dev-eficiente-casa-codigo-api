package com.savitoh.casacodigoapi.validator;

import com.savitoh.casacodigoapi.payload.NovoLivroRequest;
import com.savitoh.casacodigoapi.repository.LivroRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NovoLivroRequestIsbnUnicoValidator implements Validator {

    private final LivroRepository livroRepository;

    public NovoLivroRequestIsbnUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovoLivroRequest novoLivroRequest = (NovoLivroRequest) o;
        if(livroRepository.existsByIsbn(novoLivroRequest.getIsbn())) {
            errors.rejectValue("isbn", null, "ISBN deve ser único. Já existe Livro com este ISBN");
        }
    }
}
