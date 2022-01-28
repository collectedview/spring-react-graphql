import * as React from "react";
import Blog from "./Blog";

import { useQuery, gql } from "@apollo/client";

const BLOG_QUERY = gql`
  {
    authorById(id: "1") {
      id
      firstName
      lastName
      blog {
        id
        title
        description
        content
      }
    }
  }
`;

const BlogList = () => {
  const { data } = useQuery(BLOG_QUERY);

  if (data != null) {
    let blog_data = [data.authorById.blog];

    return (
      <>
        {blog_data.map((blog) => (
          <Blog key={blog.id} blog={blog} />
        ))}
      </>
    );
  } else {
    return "Loading... ";
  }
};

export default BlogList;
