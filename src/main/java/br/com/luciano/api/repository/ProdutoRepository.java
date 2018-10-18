package br.com.luciano.api.repository;

import br.com.luciano.api.domain.Produto;
import br.com.luciano.api.repository.helper.ProdutoRepositoryQueries;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String>,
        ProdutoRepositoryQueries {
}
