package com.springreactgraphql.springreactgraphql.service.datafetchers;

import com.springreactgraphql.springreactgraphql.model.Blog;
import com.springreactgraphql.springreactgraphql.repository.BlogRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BlogByTitleDataFetcher implements DataFetcher<List<Blog>> {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> get(DataFetchingEnvironment environment) {
        String title = environment.getArgument("title");
        return blogRepository.findByTitle(title);
    }

}
