package com.savitoh.casacodigoapi.resource;

import com.savitoh.casacodigoapi.model.Categoria;
import com.savitoh.casacodigoapi.payload.CategoriaDetalheResponse;
import com.savitoh.casacodigoapi.payload.NovaCategoriaRequest;
import com.savitoh.casacodigoapi.repository.CategoriaRepository;
import com.savitoh.casacodigoapi.validator.NovaCategoriaRequestNomeUnicoValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaResource {

    private final CategoriaRepository categoriaRepository;

    public CategoriaResource(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @InitBinder("novaCategoriaRequest")
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new NovaCategoriaRequestNomeUnicoValidator(categoriaRepository));
    }

    @PostMapping
    public ResponseEntity<CategoriaDetalheResponse> criaCategoria
            (@Valid @RequestBody NovaCategoriaRequest novaCategoriaRequest) {
        Categoria categoria = novaCategoriaRequest.transformaParaEntity();
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return new ResponseEntity<>(CategoriaDetalheResponse.transformaEntityParaDto(categoriaSalva), HttpStatus.CREATED);
    }
}
