package au.azzmosphere.pgprog.challengers.ideserve.numofclusters;

import org.junit.Test;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 30/5/17.
 */
public class TestCluster {

    @Test
    public void testAddNode() {
        Cluster cluster = new Cluster();
        cluster.addNode(new Node(0,0,1));
        cluster.addNode(new Node(2,0,1));
        cluster.addNode(new Node(3,0,1));
        cluster.addNode(new Node(5,0,1));

        assertThat(cluster.getNodes().size(), is(4));
        assertThat(cluster.getNodes().get(0).compareTo(new Node(0,0,1)), is(0));
        assertThat(cluster.getNodes().get(1).compareTo(new Node(2,0,1)), is(0));
        assertThat(cluster.getNodes().get(2).compareTo(new Node(3,0,1)), is(0));
        assertThat(cluster.getNodes().get(3).compareTo(new Node(5,0,1)), is(0));
    }

    @Test
    public void testCheckNode() {
        Cluster cluster = new Cluster();
        cluster.addNode(new Node(2,0,1));

        assertThat(cluster.checkNode(new Node(3,0,1)), is(true));
        assertThat(cluster.checkNode(new Node(0,0,1)), is(false));
        assertThat(cluster.checkNode(new Node(3,1,1)), is(true));
    }
}
