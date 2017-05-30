package au.azzmosphere.pgprog.challengers.ideserve.numofclusters;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 30/5/17.
 */
public class TestNode {
    @Test
    public void testSetterGetter1() {
        Node n = new Node(0, 0, 1);
        assertThat(n.getValue(), is(1));
        assertThat(n.getX(), is(0));
        assertThat(n.getY(), is(0));
    }

    @Test
    public void testSetterGetter2() {
        Node n = new Node(1, 1, 0);
        assertThat(n.getValue(), is(0));
        assertThat(n.getX(), is(1));
        assertThat(n.getY(), is(1));
    }
}
