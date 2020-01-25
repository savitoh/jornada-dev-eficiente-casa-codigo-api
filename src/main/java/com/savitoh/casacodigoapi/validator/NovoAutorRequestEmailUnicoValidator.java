package com.savitoh.casacodigoapi.validator;

import com.savitoh.casacodigoapi.payload.NovoAutorRequest;
import com.savitoh.casacodigoapi.repository.AutorRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NovoAutorRequestEmailUnicoValidator implements Validator {

    private final AutorRepository autorRepository;

    public NovoAutorRequestEmailUnicoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoAutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovoAutorRequest autor = (NovoAutorRequest) o;

        if(autorRepository.existsByEmail(autor.getEmail())) {
            errors.rejectValue("email", null, "Email deve ser único. Já Existe Autor cadastro com este email");
        }

    }
}
