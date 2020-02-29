package com.savitoh.casacodigoapi.resource;

import com.savitoh.casacodigoapi.model.Autor;
import com.savitoh.casacodigoapi.payload.NovoAutorRequest;
import com.savitoh.casacodigoapi.payload.AutorDetalheResponse;
import com.savitoh.casacodigoapi.repository.AutorRepository;
import com.savitoh.casacodigoapi.validator.NovoAutorRequestEmailUnicoValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/autores")
public class AutorResource {

    private final AutorRepository autorRepository;

    public AutorResource(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @InitBinder("novoAutorRequest")
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new NovoAutorRequestEmailUnicoValidator(autorRepository));
    }

    @PostMapping
    public ResponseEntity<AutorDetalheResponse> criaAutor(@Valid @RequestBody NovoAutorRequest novoAutorRequest) {
        Autor autor = novoAutorRequest.transformaParaEntity();
        Autor autorSalvo = autorRepository.save(autor);
        return new ResponseEntity<>(AutorDetalheResponse.of(autorSalvo), HttpStatus.CREATED);
    }
}
