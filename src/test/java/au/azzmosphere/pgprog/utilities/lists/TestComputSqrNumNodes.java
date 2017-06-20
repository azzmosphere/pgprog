package au.azzmosphere.pgprog.utilities.lists;

import org.junit.Test;

import static au.azzmosphere.pgprog.utilities.graph.ComputeNumNodes.computeSqrNumNodes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 19/6/17.
 */
public class TestComputSqrNumNodes {

    @Test
    public void testComputeSqrNumNodes() {
        assertThat(computeSqrNumNodes(2,2), is(9));
        assertThat(computeSqrNumNodes(3,3), is(16));
    }
}
