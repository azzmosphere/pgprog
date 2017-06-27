package au.azzmosphere.pgprog.utilities.graph;

import java.util.ArrayList;

/**
 * Single directional graph, that is put together by connecting nodes.
 *
 * Created by aaron.spiteri on 13/6/17.
 */
public class Node<T> {
    private int id;
    private T value;
    private ArrayList<Node<T>> edges = new ArrayList<>();

    /**
     *  returns the ID that has been set.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * sets the ID of the node.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the value that has been set.
     *
     * @return
     */
    public T getValue() {
        return value;
    }

    /**
     * sets the value.
     *
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * returns all connecting nodes.
     *
     * @return
     */
    public Object[] allEdges() {
        return edges.toArray();
    }

    /**
     * connects a node.
     *
     * @param node
     */
    public void addEdge(Node<T> node) {
        edges.add(node);
    }
}
