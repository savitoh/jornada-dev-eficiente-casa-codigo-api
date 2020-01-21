package com.savitoh.casacodigoapi.mapper;

import com.savitoh.casacodigoapi.dto.AutorDto;
import com.savitoh.casacodigoapi.model.Autor;

import java.util.Objects;

public final class AutorMapper {

    public static AutorDto entityToDto(Autor autor) {
        if(Objects.isNull(autor)) {
            throw new IllegalArgumentException("Argumento Não Pode Ser Nullo");
        }
        return AutorDto.builder()
                .codigo(autor.getAutorId())
                .nome(autor.getNome())
                .email(autor.getEmaill())
                .descricao(autor.getDescricao())
                .createdAt(autor.getCreatedAt())
                .build();
    }

    public static Autor dtoToEntity(AutorDto autorDto) {
        if(Objects.isNull(autorDto)) {
            throw new IllegalArgumentException("Argumento Não Pode Ser Nullo");
        }
        return Autor.builder()
                .autorId(autorDto.getCodigo())
                .nome(autorDto.getNome())
                .emaill(autorDto.getEmail())
                .descricao(autorDto.getDescricao())
                .createdAt(autorDto.getCreatedAt())
                .build();
    }
}
