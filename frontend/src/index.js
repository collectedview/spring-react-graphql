import * as React from "react";
import ReactDOM from "react-dom";
import App from "./App";

import {
  ApolloProvider,
  ApolloClient,
  createHttpLink,
  InMemoryCache,
} from "@apollo/client";

const uri_string = `${process.env.REACT_APP_GRAPHQL_API_URL}`;

const httpLink = createHttpLink({
  uri: uri_string,
});

const client = new ApolloClient({
  link: httpLink,
  cache: new InMemoryCache(),
});

ReactDOM.render(
  <ApolloProvider client={client}>
    <App />
  </ApolloProvider>,
  document.getElementById("root")
);
