package au.azzmosphere.pgprog.challengers.ideserve;

import org.junit.Test;

import au.azzmosphere.pgprog.challengers.ideserve.numofclusters.Cluster;
import au.azzmosphere.pgprog.challengers.ideserve.numofclusters.Node;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 27/5/17.
 */
public class TestNumOfClusters {
    private NumOfClusters numOfClusters = new NumOfClusters();

//    @Test
//    public void testPrunClusters() {
//        Cluster cluster1 = new Cluster(),
//                cluster2 = new Cluster()
//        ;
//
//        Node n1 = new Node(0,0,1),
//                n2 = new Node(0,2,1),
//                n3 = new Node(0,1,1),
//                n4 = new Node(1,1,1)
//        ;
//
//        cluster1.setNodes(Arrays.asList(new Node[]{n1, n3, n4}));
//        cluster2.setNodes(Arrays.asList(new Node[]{n2}));
//
//        numOfClusters.setClusters(Arrays.asList(new Cluster[]{
//                cluster1, cluster2
//        }));
//        numOfClusters.prunClusters();
//
//        assertThat(numOfClusters.getClusters().size(), is(1));
//    }
}
