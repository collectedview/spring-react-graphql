package com.springreactgraphql.springreactgraphql.service;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.springreactgraphql.springreactgraphql.service.datafetchers.AuthorDataFetcher;
import com.springreactgraphql.springreactgraphql.service.datafetchers.BlogDataFetcher;
import com.springreactgraphql.springreactgraphql.service.datafetchers.BlogByTitleDataFetcher;
import com.springreactgraphql.springreactgraphql.service.datafetchers.CountryDataFetcher;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLService {

    @Autowired
    CountryDataFetcher countryDataFetcher;

    @Autowired
    AuthorDataFetcher authorDataFetcher;

    @Autowired
    BlogDataFetcher blogDataFetcher;

    @Autowired
    BlogByTitleDataFetcher blogByTitleDataFetcher;

    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("allAuthors", authorDataFetcher))
                .type(newTypeWiring("Query")
                        .dataFetcher("allBlogs", blogDataFetcher))
                .type(newTypeWiring("Query")
                        .dataFetcher("allCountries", countryDataFetcher))
                .type(newTypeWiring("Query")
                        .dataFetcher("blogByTitle", blogByTitleDataFetcher))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    public ExecutionResult executeGraphQL(String query) {
        return graphQL.execute(query);
    }

}
