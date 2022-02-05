package com.springreactgraphql.springreactgraphql.service.datafetchers;

import com.springreactgraphql.springreactgraphql.model.Country;
import com.springreactgraphql.springreactgraphql.repository.CountryRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryDataFetcher implements DataFetcher<List<Country>> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> get(DataFetchingEnvironment environment) {
        return countryRepository.findAll();
    }

}