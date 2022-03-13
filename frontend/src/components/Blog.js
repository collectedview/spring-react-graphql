import * as React from "react";

import BlogViewStatistic from "./components/BlogViewStatistic";

const Blog = (props) => {
  const { blog } = props;
  return (
    <div>
      <div>
        <h4>{blog.title}</h4>
        <p>{blog.description}</p>
        <BlogViewStatistic title={blog.title} />
      </div>
    </div>
  );
};

export default Blog;
