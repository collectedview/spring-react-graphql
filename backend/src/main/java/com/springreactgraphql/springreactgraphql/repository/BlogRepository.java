package com.springreactgraphql.springreactgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springreactgraphql.springreactgraphql.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    // Blog By Title DataFetcher
    List<Blog> findByTitle(String title);

}