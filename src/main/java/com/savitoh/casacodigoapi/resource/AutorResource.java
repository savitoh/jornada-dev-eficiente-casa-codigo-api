package com.savitoh.casacodigoapi.resource;

import com.savitoh.casacodigoapi.model.Autor;
import com.savitoh.casacodigoapi.payload.AutorRequest;
import com.savitoh.casacodigoapi.payload.AutorResponse;
import com.savitoh.casacodigoapi.repository.AutorRepository;
import com.savitoh.casacodigoapi.validator.AutorCustomValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/autor")
public class AutorResource {

    private final AutorRepository autorRepository;

    private final AutorCustomValidator autorCustomValidator;

    public AutorResource(AutorRepository autorRepository, AutorCustomValidator autorCustomValidator) {
        this.autorRepository = autorRepository;
        this.autorCustomValidator = autorCustomValidator;
    }

    @PostMapping
    public ResponseEntity<AutorResponse> criaAutor(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autor = autorRequest.transformaParaEntity();
        autorCustomValidator.validate(autor);
        Autor autorSalvo = autorRepository.save(autor);
        return new ResponseEntity<>(AutorResponse.transformaEntityParaDto(autorSalvo), HttpStatus.CREATED);
    }
}
