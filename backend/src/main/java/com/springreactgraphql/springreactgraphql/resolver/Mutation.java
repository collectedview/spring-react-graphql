package com.springreactgraphql.springreactgraphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springreactgraphql.springreactgraphql.model.Author;
import com.springreactgraphql.springreactgraphql.model.Blog;
import com.springreactgraphql.springreactgraphql.repository.AuthorRepository;
import com.springreactgraphql.springreactgraphql.repository.BlogRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private BlogRepository blogRepository;
    @Autowired
    public Mutation(AuthorRepository authorRepository, BlogRepository blogRepository) {
        this.authorRepository = authorRepository;
        this.blogRepository = blogRepository;
    }
    public Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        authorRepository.save(author);
        return author;
    }
    public Blog createBlog(String title, String description, Integer authorId) {
        Blog blog = new Blog();
        blog.setAuthor(new Author(authorId));
        blog.setTitle(title);
        blog.setDescription(description);
        blogRepository.save(blog);
        return blog;
    }
    public boolean deleteTutorial(Integer id) {
        blogRepository.deleteById(id);
        return true;
    }
    public Blog updateTutorial(Integer id, String title, String description) throws Exception {
        Optional<Blog> optBlog = blogRepository.findById(id);
        if (optBlog.isPresent()) {
            Blog blog = optBlog.get();
            if (title != null)
                blog.setTitle(title);
            if (description != null)
                blog.setDescription(description);
            blogRepository.save(blog);
            return blog;
        }
        throw new Exception("No Blog to Update");
    }
}