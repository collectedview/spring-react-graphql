package com.springreactgraphql.springreactgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springreactgraphql.springreactgraphql.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}