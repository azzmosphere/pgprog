package au.azzmosphere.pgprog.utilities.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by aaron.spiteri on 18/6/17.
 *
 * Given a input of NxN for matrix size, produce a linked list of nodes.
 */
public class MatrixBuilder<T> {

    private static final Logger logger = LoggerFactory.getLogger(MatrixBuilder.class);

    /**
     * Generate a two dimensional array of vertices.
     *
     * @param height
     * @param width
     * @param values
     * @return
     */
    public Node generateMatrix(int height, int width, List<T> values) {
        return generateMatrix(height, width, values.toArray());
    }

    public Node generateMatrix(int height, int width, Object[] values) {
        logger.debug("building matrix");

        Node<T>[] vertices = createNodes(values);
        Node<T> v = vertices[0];

        for (int n = 0; n < vertices.length; n++) {
            Node<T> vertex = vertices[n];

            int currentRow = (n / width) + 1;
            if ((n + 1) <= (currentRow * width - 1)) {
                vertex.addEdge(vertices[n + 1]);
            }

            if ((n + width) < (height * width)) {
                vertex.addEdge(vertices[n + width]);
            }
        }

        return v;
    }

    private Node<T>[] createNodes(Object[] values) {
        Node<T>[] vertices = new Node[values.length];

        int i = 0;
        for (Object o : values) {
            T value = (T) o;
            vertices[i] = new Node<T>();
            vertices[i].setValue(value);
            vertices[i].setId(i++);
        }

        return vertices;
    }

    public Node generateMatrix(int width, ArrayList<Node> nodes) {
        int j = 0;
        for (int y = 0; y <= width; y++) {
            for (int i = 0; i <= y; i++) {
                int e1 = -1, e2 = -1;
                Node n = new Node();
                n.setId(j++);
                nodes.add(n);

                if (i > 0) {
                    e1 = j - 2;
                    nodes.get(e1).addEdge(n);
                }

                if (y > 0 && i < y) {
                    e2 = (j - 1) - y;
                    nodes.get(e2).addEdge(n);
                }
                else if (i == y && y > 0) {
                    e2 = (j - 1) - (y + 1);
                    nodes.get(e2).addEdge(n);
                }
                System.out.print(n.getId() + "(" + e1 + "," + e2 + ") ");
            }
            System.out.println("");
        }

        return nodes.get(0);
    }

}
