package au.azzmosphere.pgprog.challengers.ideserve.numofclusters;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by aaron.spiteri on 27/5/17.
 */
public class Cluster  {

    private List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * shortcut for cluster.getNode().add(n);
     *
     * @param n
     */
    public void addNode(Node n) {
        nodes.add(n);
    }

    /**
     * if Node n is no further than 1 edges left or right from any other
     * node in cluster than return true.
     *
     * @param n
     * @return
     */
    public boolean checkNode(Node n) {

        // NOTE: Could add a speed hack here,
        for (Node checkNode : getNodes()) {
            int yDistance = checkNode.getY() - n.getY(), xDistance = checkNode.getX() - n.getX();
            if ((distanceCheck(xDistance)) && distanceCheck(yDistance)) {
                return true;
            }
        }

        return false;
    }

    private boolean distanceCheck(int coordinate) {
        if (coordinate >= -1 && coordinate <= 1) {
            return true;
        }
        return false;
    }

    public void mergeCluster(Cluster o) {
        for (Node n : o.getNodes()) {
            if (!hasNode(n)) {
                addNode(n);
            }
        }
    }

    private boolean hasNode(Node t) {
        for (Node n : getNodes()) {
            if (n.getX() == t.getX() && n.getY() == t.getY()) {
                return true;
            }
        }
        return false;
    }
}
