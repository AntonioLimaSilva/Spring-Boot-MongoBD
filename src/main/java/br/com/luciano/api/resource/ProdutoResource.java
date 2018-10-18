package br.com.luciano.api.resource;

import br.com.luciano.api.domain.Produto;
import br.com.luciano.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class ProdutoResource {

    @Autowired private ProdutoRepository produtoRepository;

    @PostMapping public ResponseEntity<?> insert(@RequestBody @Valid Produto produto) {
//        if(result.hasErrors()) {
//            return ResponseEntity.badRequest().body(result.getFieldErrors());
//        }
        Produto produtoSalvo = this.produtoRepository.save(produto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(produtoSalvo.getId()).toUri();
        return ResponseEntity.created(location).body(produtoSalvo);
    }

    @GetMapping public ResponseEntity<List<Produto>> findByName(@RequestParam String nome) {
        return ResponseEntity.ok(this.produtoRepository.findByName(nome));
    }

    @GetMapping("/{id}") public ResponseEntity<Produto> findById(@PathVariable String id) {
        Optional<Produto> produtoOptional = this.produtoRepository.findById(id);
        return produtoOptional.isPresent() ? ResponseEntity.ok(produtoOptional.get()) : ResponseEntity.notFound().build();
    }

    

}
