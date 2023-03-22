package com.sariq.simplegraph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Tests whether directed acyclical and cyclical graphs are topologically sorted
@SpringBootTest
class TopoSortTest {
    
    @Autowired
    private GraphService graphService;

    @Test
    public void TestCyclic() throws Exception {
        graphService.resetGraph();
        List<String> nodes = List.of("I","have","Cycles!");
        List<List<String>> edges = List.of(
                                            List.of("I","have"),
                                            List.of("have","Cycles!"),
                                            List.of("Cycles!","I")
                                            );
        for (String node : nodes) {
            graphService.addNode(node);
        }

        for (List<String> edge : edges) {
            graphService.addEdge(edge);
        }
        List<Node> sorted = graphService.topologicalSort();
        assertEquals(null,sorted);
    }

    @Test
    public void TestAcyclic() throws Exception {
        graphService.resetGraph();
        List<Node> sortedComparison = List.of(
                                            new Node("7"),new Node("5"),
                                            new Node("11"),new Node("3"),
                                            new Node("10"),new Node("8"),
                                            new Node("9"),new Node("2")
                                            );
        List<String> nodes = List.of("2","3","9","5","10","7","8","11");
        List<List<String>> edges = List.of(
                                            List.of("3","8"),
                                            List.of("3","10"),
                                            List.of("5","11"),
                                            List.of("7","8"),
                                            List.of("7","11"),
                                            List.of("8","9"),
                                            List.of("11","2"),
                                            List.of("11","9"),
                                            List.of("11","10")
                                            );

        for (String node : nodes) {
            graphService.addNode(node);
        }

        for (List<String> edge : edges) {
            graphService.addEdge(edge);
        }
        List<Node> sorted = graphService.topologicalSort();
        assertEquals(sortedComparison,sorted);
    }
}
