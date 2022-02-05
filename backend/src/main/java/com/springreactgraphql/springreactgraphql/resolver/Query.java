package com.springreactgraphql.springreactgraphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springreactgraphql.springreactgraphql.model.Author;
import com.springreactgraphql.springreactgraphql.model.Blog;
import com.springreactgraphql.springreactgraphql.repository.AuthorRepository;
import com.springreactgraphql.springreactgraphql.repository.BlogRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private BlogRepository blogRepository;
    @Autowired
    public Query(AuthorRepository authorRepository, BlogRepository blogRepository) {
        this.authorRepository = authorRepository;
        this.blogRepository = blogRepository;
    }
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    public Iterable<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }
    public Integer countAuthors() {
        return Math.toIntExact(authorRepository.count());
    }
    public Integer countBlogs() {
        return Math.toIntExact(blogRepository.count());
    }
}