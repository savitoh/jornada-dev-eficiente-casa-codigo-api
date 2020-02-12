package com.savitoh.casacodigoapi.validator;

import com.savitoh.casacodigoapi.payload.NovoLivroRequest;
import com.savitoh.casacodigoapi.repository.LivroRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NovoLivroRequestTituloUnicoValidator implements Validator {

    private final LivroRepository livroRepository;

    public NovoLivroRequestTituloUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovoLivroRequest novoLivroRequest = (NovoLivroRequest) o;
        if(livroRepository.existsByTitulo(novoLivroRequest.getTitulo())) {
            errors.rejectValue("título", null, "Título deve ser único. Já existe livro com este título");
        }
    }
}
