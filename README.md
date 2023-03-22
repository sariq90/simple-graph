# simple-graph
This is a small demo project with Spring to read in and sort graphs. It uses GET requests to retrieve data and POST to update/read in data.
## Getting Started
- Clone the project
- Execute ./mvnw spring-boot:run in the root directory to build the project
- Navigate to localhost:8080 via Browser, Postman or whatever tool you fancy
## Available Commands
The following GET and POST endpoints are implemented:
### GET
`/graph` returns the current graph

`/sort` returns a topologically sorted graph (largest-numbered available Vertex first), see [Wikipedia](https://en.wikipedia.org/wiki/Topological_sorting#Depth-first_search)
### POST
`/add/node` adds a single node

`/add/nodes` adds an array of nodes like `[a,b,c,...]`

`/add/edge` adds an edge [from, to]

`/add/edges` adds multiple edges `[[e1f,e1t],[e2f,e2t],...]`

`/reset` resets the graph to an empty graph

## Further Improvements
The following are example points and functionality that can be added:
- The `Node` class only offers a `label` but could support arbitrary attributes and methods in principle
- Graphs do not persist
- Confirmation logging/messaging on successful requests (e.g. did the node I just uploaded overwrite a node with the same label?)
- Meaningful error messages
- Sensible error handling
- No security or hardening
