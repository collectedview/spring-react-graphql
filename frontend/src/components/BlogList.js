import * as React from "react";
import Blog from "./Blog";

import { useQuery, gql } from "@apollo/client";

const BLOG_QUERY = gql`
  {
    allBlogs {
      title
      description
    }
  }
`;

const BlogList = () => {
  const { data } = useQuery(BLOG_QUERY);

  if (data != null) {
    return (
      <>
        {data.allBlogs.map((blog) => (
          <Blog key={blog.id} blog={blog} />
        ))}
      </>
    );
  } else {
    return "Loading... ";
  }
};

export default BlogList;
