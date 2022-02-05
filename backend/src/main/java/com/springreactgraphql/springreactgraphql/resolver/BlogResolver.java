package com.springreactgraphql.springreactgraphql.resolver;

import com.springreactgraphql.springreactgraphql.model.Author;
import com.springreactgraphql.springreactgraphql.model.Blog;
import com.springreactgraphql.springreactgraphql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogResolver {
    @Autowired
    private AuthorRepository authorRepository;
    public BlogResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author getAuthor(Blog blog) {
        return authorRepository.findById(blog.getAuthor().getId()).orElseThrow(null);
    }
}