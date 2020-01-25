package com.savitoh.casacodigoapi.service;

import com.savitoh.casacodigoapi.model.Categoria;
import com.savitoh.casacodigoapi.repository.CategoriaRepository;
import com.savitoh.casacodigoapi.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public boolean existeCategoriaComMesmoNomeDesconsiderandoAcentos(final String nome) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findFirstByNomeIgnoreCase(nome);
        return categoriaOptional.map(categoria -> {
            final String nomeCategoriaSemAcentos = StringUtils.removeAcentos(categoria.getNome());
            final String nomeSemAcentos = StringUtils.removeAcentos(nome);
            return nomeSemAcentos.equals(nomeCategoriaSemAcentos);
        }).orElse(false);
    }
}
