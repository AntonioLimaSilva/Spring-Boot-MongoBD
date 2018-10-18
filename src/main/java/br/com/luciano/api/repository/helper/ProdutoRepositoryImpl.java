package br.com.luciano.api.repository.helper;

import br.com.luciano.api.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQueries {

    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public List<Produto> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nome").regex(name));
        return this.mongoTemplate.find(query, Produto.class);
    }
}
