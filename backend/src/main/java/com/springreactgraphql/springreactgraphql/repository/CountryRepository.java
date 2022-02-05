package com.springreactgraphql.springreactgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springreactgraphql.springreactgraphql.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}