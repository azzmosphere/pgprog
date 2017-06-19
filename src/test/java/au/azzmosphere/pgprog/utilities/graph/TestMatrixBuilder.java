package au.azzmosphere.pgprog.utilities.graph;

import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 19/6/17.
 */
public class TestMatrixBuilder {
    private MatrixBuilder<Boolean> matrixBuilder = new MatrixBuilder();

    @Test
    public void testGenerateMatrix() {
        int h = 2, w = 2;
        ArrayList<Boolean> values = new ArrayList<>();
        values.add(true);
        values.add(false);
        values.add(false);
        values.add(true);

        Node<Boolean> n = matrixBuilder.generateMatrix(h, w, values);
        assertThat(n.getId(), is(0));
        assertThat(n.allEdges().get(0).getId(), is(1));
        assertThat(n.allEdges().get(1).getId(), is(2));
        assertThat(n.allEdges().get(0).allEdges().get(0).getId(), is(3));
    }
}
