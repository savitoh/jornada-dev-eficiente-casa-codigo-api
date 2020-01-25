package com.savitoh.casacodigoapi.resource;

import com.savitoh.casacodigoapi.model.Categoria;
import com.savitoh.casacodigoapi.payload.NovaCategoriaRequest;
import com.savitoh.casacodigoapi.payload.NovaCategoriaResponse;
import com.savitoh.casacodigoapi.repository.CategoriaRepository;
import com.savitoh.casacodigoapi.service.CategoriaService;
import com.savitoh.casacodigoapi.validator.NovaCategoriaRequestNomeUnicoValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/categoria")
public class CategoriaResource {

    private final CategoriaRepository categoriaRepository;

    private final CategoriaService categoriaService;

    public CategoriaResource(CategoriaRepository categoriaRepository, CategoriaService categoriaService) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaService = categoriaService;
    }

    @InitBinder("novaCategoriaRequest")
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new NovaCategoriaRequestNomeUnicoValidator(categoriaService));
    }

    @PostMapping
    public ResponseEntity<NovaCategoriaResponse> criaCategoria
            (@Valid @RequestBody NovaCategoriaRequest novaCategoriaRequest) {

        Categoria categoria = novaCategoriaRequest.transformaParaEntity();
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return new ResponseEntity<>(NovaCategoriaResponse.transformaEntityParaDto(categoriaSalva), HttpStatus.CREATED);
    }
}
