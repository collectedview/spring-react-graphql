import * as React from "react";

import { useQuery, gql } from "@apollo/client";

const TITLE_QUERY = gql`
  query blogByTitle($title: String!) {
    blogByTitle(title: $title) {
      views
    }
  }
`;

const BlogViewStatistic = ({ title }) => {
  const { data } = useQuery(TITLE_QUERY, {
    variables: { title },
  });

  if (data != null) {
    return <p>{data.blogByTitle[0].views}</p>;
  } else {
    return <p>0</p>;
  }
};

export default BlogViewStatistic;
