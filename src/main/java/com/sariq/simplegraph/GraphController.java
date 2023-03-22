package com.sariq.simplegraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Controller to serve requests via REST.
@RestController
public class GraphController {
    @Autowired
    private GraphService graphService;

    // Returns the graph as a map of its nodes and a set of their directed connections.
    @GetMapping("/graph")
    public HashMap<Node,HashSet<Node>> getGraph() {
        return graphService.getGraph();
    }

    // Returns the graph topologically sorted (largest-numbered available node first), null if the graph has cycles.
    @GetMapping("/sort")
    public List<Node> topologicalSort() {
        return graphService.topologicalSort();
    }

    // Adds a single node to the graph. Takes the entire request body (!) as the label.
    @PostMapping("/add/node")
    public void addNode(@RequestBody String label) {
        graphService.addNode(label);
    }
    
    // Adds an array of nodes to the graph.
    @PostMapping("/add/nodes")
    public void addNodes(@RequestBody List<String> labels) {
        for (String label : labels) {
            graphService.addNode(label);
        }
    }

    // Adds an edge array to the graph, convention is [from, to]. Only first two edge array values are considered.
    @PostMapping("/add/edges")
    public void addEdges(@RequestBody List<List<String>> edges) {
        for (List<String> edge : edges) {
            graphService.addEdge(edge);
        }
    }

    // Adds an array of edge arrays to the graph. Only first two edge array values are considered.
    @PostMapping("/add/edge")
    public void addEdge(@RequestBody List<String> edge) {
        graphService.addEdge(edge);
    }

    // Resets the graph to an empty graph.
    @PostMapping("/reset")
    public void resetGraph() {
        graphService.resetGraph();
    }
}
