package br.com.luciano.api.repository.helper;

import br.com.luciano.api.domain.Produto;

import java.util.List;

public interface ProdutoRepositoryQueries {

    List<Produto> findByName(String name);

}
