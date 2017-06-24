package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.utilities.graph.Node;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 14/6/17.
 */
public class TestMinReachSrcDestWordGraph {
    private String[] dictionaryArray = new String[]{"BCCI","AICC","ICC","CCI","MCC","MCA", "ACC"};
    private MinReachSrcDestWordGraph  minReachSrcDestWordGraph = new MinReachSrcDestWordGraph();

    @Test
    public void testAppendMap() {
        Node<String> n = new Node<>();
        n.setId(0);
        n.setValue(dictionaryArray[0]);
        minReachSrcDestWordGraph.appendMap(dictionaryArray, n);
        assertThat(n.allEdges().length, is(1));
        assertThat(((Node) n.allEdges()[0]).getId(), is(3));
    }

    @Test
    public void testAppendMap2() {
        Node<String> n = new Node<>();
        n.setId(1);
        n.setValue(dictionaryArray[1]);
        minReachSrcDestWordGraph.appendMap(dictionaryArray, n);

        assertThat(n.allEdges().length, is(2));
        assertThat(((Node) n.allEdges()[0]).getId(), is(2));
        assertThat(((Node) n.allEdges()[1]).getId(), is(6));
    }

    @Test
    public void testAppendMap3() {
        Node<String> n = new Node<>();
        n.setId(2);
        n.setValue(dictionaryArray[2]);
        minReachSrcDestWordGraph.appendMap(dictionaryArray, n);

        assertThat(n.allEdges().length, is(3));
        assertThat(((Node) n.allEdges()[0]).getId(), is(1));
        assertThat(((Node) n.allEdges()[1]).getId(), is(4));
        assertThat(((Node) n.allEdges()[2]).getId(), is(6));
    }
}
