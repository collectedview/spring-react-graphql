package com.springreactgraphql.springreactgraphql.service.datafetchers;

import com.springreactgraphql.springreactgraphql.model.Author;
import com.springreactgraphql.springreactgraphql.repository.AuthorRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorDataFetcher implements DataFetcher<List<Author>> {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> get(DataFetchingEnvironment environment) {
        return authorRepository.findAll();
    }

}