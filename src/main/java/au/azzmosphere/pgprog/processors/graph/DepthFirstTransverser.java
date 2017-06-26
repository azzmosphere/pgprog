package au.azzmosphere.pgprog.processors.graph;

import au.azzmosphere.pgprog.utilities.graph.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


/**
 * Created by aaron.spiteri on 19/6/17.
 *
 * The abstract transverser class can be sub classed to create a generic transverser.
 * For the concrete class it must define a method.
 *
 * handleFoundPath() which is called each time a path is found. This can be considered
 * a specialist proxy pattern, where the concrete class is specialist for whatever is
 * needed and the base class does the generic stuff that is needed by all everything.
 *
 */
public abstract class DepthFirstTransverser<T> {
    private static final Logger logger = LoggerFactory.getLogger(DepthFirstTransverser.class);

    /**
     * Override this method in the subclass when a found node is not when the ID of target
     * node is the same as the target node of current vertex in the path.
     *
     * By default this method will compare targetNode.getId() to currentNode.getId()
     *
     * @param n1
     * @param n2
     * @return
     */
    protected boolean checkNode(Node n1, Node n2) {
        return n1.getId() == n2.getId();
    }

    /**
     * This method must be overwritten by the sub class.  It will do the heavy lifting
     * for the concrete class which is normally a challenge.
     *
     * @param foundPath
     */
    protected abstract void handleFoundPath(List<Node<T>> foundPath);

    protected abstract List<Node<T>> cloneList(List<Node<T>> list);

    /**
     * Traverse the tree starting at startNode, add each path to foundPaths and only stop if
     *   1) the path reaches a node that has been previously discovered.
     *   2) the targetNode is found.
     *
     * if the target node is found then return true.
     *
     * @param startNode
     * @param targetNode
     * @return
     */

    /*
     * Removing the found nodes and using a proxy (specialist) pattern.
     *
     * The callback method is handleFoundPath(LinkedList<Node<T>> foundPath)
     *
     * Hoping to save memory by allowing the sub class to decide what it will
     * do with the found path.
     */
    public boolean transverseMap(Node startNode, Node targetNode, List<Node<T>> transversedPaths) {
        if ((transversedPaths.size() > 1) && transversedPaths.contains(startNode)) {
            transversedPaths.clear();
            return false;
        }

        transversedPaths.add(startNode);
        if (checkNode(startNode, targetNode)) {
            logger.debug("path found - calling handler with found path");
            handleFoundPath(transversedPaths);
            return true;
        }

        for (Object e : startNode.allEdges()) {
            Node n = (Node) e;
            transverseMap(n, targetNode, cloneList(transversedPaths));
        }
        transversedPaths.clear();
        return false;
    }
}
