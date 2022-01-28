import * as React from "react";

const Blog = (props) => {
  const { blog } = props;
  return (
    <div>
      <div>
        <h4>{blog.title}</h4>
        <p>{blog.description}</p>
      </div>
    </div>
  );
};

export default Blog;
