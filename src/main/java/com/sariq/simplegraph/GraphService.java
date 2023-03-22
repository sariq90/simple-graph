package com.sariq.simplegraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

// Service including the necessary operations and logic to serve the GraphController.
@Service
public class GraphService {
    private static final HashMap<Node,HashSet<Node>> graph = new HashMap<>();
    
    public void addNode(String label) {
        graph.putIfAbsent(new Node(label), new HashSet<>());
    }

    public void addEdge(List<String> edge) {
        graph.get(new Node(edge.get(0))).add(new Node(edge.get(1)));
    }

    public HashMap<Node,HashSet<Node>> getGraph() {
        return graph;
    }

    public void resetGraph() {
        graph.clear();
    }

    public List<Node> topologicalSort() {
        TopologicalSort sort = new TopologicalSort(graph);
        return sort.topoSorted();
    }

}
