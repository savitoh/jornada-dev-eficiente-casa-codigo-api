package com.savitoh.casacodigoapi.resource;

import com.savitoh.casacodigoapi.dto.AutorDto;
import com.savitoh.casacodigoapi.mapper.AutorMapper;
import com.savitoh.casacodigoapi.model.Autor;
import com.savitoh.casacodigoapi.service.AutorService;
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

    private final AutorService autorService;

    public AutorResource(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorDto> criaAutor(@Valid @RequestBody AutorDto autorDto) {
        Autor autor = AutorMapper.dtoToEntity(autorDto);
        Autor autorSaved = autorService.save(autor);
        return new ResponseEntity<>(AutorMapper.entityToDto(autorSaved), HttpStatus.CREATED);
    }
}
