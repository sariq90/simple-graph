package com.sariq.simplegraph;

import java.util.Objects;

// Node class for use in the app. Stores only a label String as attribute, but can be expanded in principle.
public class Node {
    public String label;

    public Node(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node other = (Node)obj;
        return this.label.equals(other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }

}
