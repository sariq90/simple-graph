package com.sariq.simplegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Class to sort the graph topologically
public class TopologicalSort {
    private final HashMap<Node,HashSet<Node>> graph;
    private List<Node> notPermanent = new ArrayList<>();
    private List<Node> temporary = new ArrayList<>();
    private List<Node> unmarked = new ArrayList<>();
    private List<Node> solution = new ArrayList<>();
    
    public TopologicalSort(HashMap<Node,HashSet<Node>> graph) {
        this.graph = graph;
        graph.forEach((node, nodeList) -> {
            notPermanent.add(node);
            unmarked.add(node);
        });
    }

    // Implements a Depth-First-Search in order to sort the graph topologically.
    public List<Node> topoSorted() {
        while (!notPermanent.isEmpty()) {
            Node node = unmarked.get(0);
            // Graph is cyclic
            if (visit(node) == true) {
                return null;
            }
        }
        return solution;
    }

    private boolean visit(Node node) {
        if (!notPermanent.contains(node)) {
            return false;
        }
        // Graph is cyclic
        if (temporary.contains(node)) {
            return true;
        }
        temporary.add(node);
        for (Node connectedNode : graph.get(node)) {
            if (visit(connectedNode) == true) {
                return true;
            }
        }
        notPermanent.remove(node);
        temporary.remove(node);
        unmarked.remove(node);
        solution.add(0,node);
        return false;
    }
}
