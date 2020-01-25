package com.savitoh.casacodigoapi.validator;

import com.savitoh.casacodigoapi.payload.NovaCategoriaRequest;
import com.savitoh.casacodigoapi.service.CategoriaService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NovaCategoriaRequestNomeUnicoValidator implements Validator {

    private final CategoriaService categoriaService;

    public NovaCategoriaRequestNomeUnicoValidator(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovaCategoriaRequest novaCategoriaRequest = (NovaCategoriaRequest) o;
        if(categoriaService.existeCategoriaComMesmoNomeDesconsiderandoAcentos(novaCategoriaRequest.getNome())) {
            errors.rejectValue("nome", null, "Nome deve ser único. Já existe Categoria com este nome");
        }
    }
}
