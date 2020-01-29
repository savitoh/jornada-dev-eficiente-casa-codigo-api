package com.savitoh.casacodigoapi.resource;

import com.savitoh.casacodigoapi.model.Categoria;
import com.savitoh.casacodigoapi.model.Livro;
import com.savitoh.casacodigoapi.payload.LivroProjecaoCompactaResponse;
import com.savitoh.casacodigoapi.payload.NovoLivroRequest;
import com.savitoh.casacodigoapi.payload.NovoLivroResponse;
import com.savitoh.casacodigoapi.repository.CategoriaRepository;
import com.savitoh.casacodigoapi.repository.LivroRepository;
import com.savitoh.casacodigoapi.validator.NovoLivroRequestCodigoCategoriaExisteValidator;
import com.savitoh.casacodigoapi.validator.NovoLivroRequestIsbnUnicoValidator;
import com.savitoh.casacodigoapi.validator.NovoLivroRequestTituloUnicoValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/livro")
public class LivroResource {

    private final LivroRepository livroRepository;

    private final CategoriaRepository categoriaRepository;

    public LivroResource(LivroRepository livroRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @InitBinder("novoLivroRequest")
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new NovoLivroRequestTituloUnicoValidator(livroRepository),
                                 new NovoLivroRequestIsbnUnicoValidator(livroRepository),
                                 new NovoLivroRequestCodigoCategoriaExisteValidator(categoriaRepository));
    }

    @PostMapping
    public ResponseEntity<NovoLivroResponse> criaLivro(@Valid @RequestBody NovoLivroRequest novoLivroRequest) {
        Categoria categoria = categoriaRepository.findById(novoLivroRequest.getCodigoCategoria()).get();
        Livro livro = novoLivroRequest.transformaParaEntity(categoria);
        Livro livroSalvo = livroRepository.save(livro);
        NovoLivroResponse novoLivroResponse = new NovoLivroResponse(livroSalvo);
        return  new ResponseEntity<>(novoLivroResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LivroProjecaoCompactaResponse>> obtemTodosLivros() {
        List<LivroProjecaoCompactaResponse>  livroProjecaoCompactaResponse =
                livroRepository.obtemTodosLivrosProjetados();
        return ResponseEntity.ok().body(livroProjecaoCompactaResponse);
    }
}
