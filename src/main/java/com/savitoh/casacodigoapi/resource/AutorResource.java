package com.savitoh.casacodigoapi.resource;

import com.savitoh.casacodigoapi.dto.AutorDto;
import com.savitoh.casacodigoapi.model.Autor;
import com.savitoh.casacodigoapi.repository.AutorRepository;
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

    public AutorResource(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorDto> criaAutor(@Valid @RequestBody AutorDto autorDto) {
        Autor autor = autorDto.transformaParaEntity();
        Autor autorSalvo = autorRepository.save(autor);
        return new ResponseEntity<>(autorDto.transformaEntityParaDto(autorSalvo), HttpStatus.CREATED);
    }
}
