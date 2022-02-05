package com.springreactgraphql.springreactgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springreactgraphql.springreactgraphql.model.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}