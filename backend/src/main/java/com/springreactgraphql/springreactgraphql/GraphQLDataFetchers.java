package com.springreactgraphql.springreactgraphql;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "1",
                    "firstName", "Joe",
                    "lastName", "Alongi",
                    "blogId", "1"),
            ImmutableMap.of("id", "2",
                    "firstName", "Joe",
                    "lastName", "Alongi",
                    "blogId", "2"),
            ImmutableMap.of("id", "3",
                    "firstName", "Joe",
                    "lastName", "Alongi",
                    "blogId", "3")
    );

    private static List<Map<String, String>> blogs = Arrays.asList(
            ImmutableMap.of("id", "1",
                    "title", "Blog One - Blog One - Blog One",
                    "description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    "content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                    ),
            ImmutableMap.of("id", "2",
                    "title", "Blog Two - Blog Two - Blog Two",
                    "description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    "content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                    ),
            ImmutableMap.of("id", "3",
                    "title", "Blog Three - Blog Three - Blog Three",
                    "description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    "content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
    );

    public DataFetcher getBlogByAuthorIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String authorId = dataFetchingEnvironment.getArgument("id");
            return authors
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getBlogDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> author = dataFetchingEnvironment.getSource();
            String blogId = author.get("blogId");
            return blogs
                    .stream()
                    .filter(blog -> blog.get("id").equals(blogId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
