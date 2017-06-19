package au.azzmosphere.pgprog.utilities.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public Node generateMatrix(int height, int width, ArrayList<T> values) {
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

    private Node<T>[] createNodes(ArrayList<T> values) {
        Node<T>[] vertices = new Node[values.size()];

        int i = 0;
        for (T value : values) {
            vertices[i] = new Node<T>();
            vertices[i].setValue(value);
            vertices[i].setId(i++);
        }

        return vertices;
    }
}
