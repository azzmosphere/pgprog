package au.azzmosphere.pgprog.challengers.ideserve.numofclusters;

/**
 * Created by aaron.spiteri on 30/5/17.
 */
public class Node  implements Comparable<Node> {
    int x, y, value;

    public Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return (x - o.getX()) + (y - o.getY());
    }
}
