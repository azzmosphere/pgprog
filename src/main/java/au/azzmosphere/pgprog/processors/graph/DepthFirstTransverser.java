package au.azzmosphere.pgprog.processors.graph;

import au.azzmosphere.pgprog.utilities.graph.Node;

import java.util.ArrayList;

import static au.azzmosphere.pgprog.utilities.lists.Clone.cloneArray;

/**
 * Created by aaron.spiteri on 19/6/17.
 */
public abstract class DepthFirstTransverser<T> {
    protected boolean checkNode(Node n1, Node n2) {
        return n1.getId() == n2.getId();
    }

    /**
     * Traverse the tree starting at startNode, add each path to foundPaths and only stop if
     *   1) the path reaches a node that has been previously discovered.
     *   2) the targetNode is found.
     *
     * if the target node is found then return true.
     *
     * @param startNode
     * @param targetNode
     * @param foundPaths
     * @return
     */
    public boolean transverseMap(Node startNode, Node targetNode, ArrayList<ArrayList<Node<T>>> foundPaths, ArrayList<Node<T>> transversedPaths) {

        if (transversedPaths.contains(startNode)) {
            return false;
        }

        transversedPaths.add(startNode);
        if (checkNode(startNode, targetNode)) {
            foundPaths.add(transversedPaths);
            return true;
        }

        for (Object e : startNode.allEdges()) {
            Node n = (Node) e;
            transverseMap(n, targetNode, foundPaths, cloneArray(transversedPaths));
        }
        return false;
    }
}
