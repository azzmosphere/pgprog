package au.azzmosphere.pgprog.challengers.ideserve;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import au.azzmosphere.pgprog.challengers.ideserve.numofclusters.Cluster;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 27/5/17.
 */
public class TestNumOfClusters {
    private NumOfClusters numOfClusters;

//    @Before
//    public void createObject() {
//        numOfClusters = new NumOfClusters();
//    }
//
//    @Test
//    public void testRegionCount() {
//        List<Integer> list = Arrays.asList(new Integer[]{1, 1, 1, 1});
//        assertThat(numOfClusters.regionCount(list), is(1));
//        assertThat(numOfClusters.clustersList().get(0).getStartPoint(), is(0));
//        assertThat(numOfClusters.clustersList().get(0).getEndPoint(), is(3));
//    }
//
//    @Test
//    public void testRegionCount2() {
//        List<Integer> list = Arrays.asList(new Integer[]{1, 0, 1, 1, 0, 1});
//        assertThat(numOfClusters.regionCount(list), is(3));
//
//        assertThat(numOfClusters.clustersList().get(0).getStartPoint(), is(0));
//        assertThat(numOfClusters.clustersList().get(0).getEndPoint(), is(0));
//
//        assertThat(numOfClusters.clustersList().get(1).getStartPoint(), is(2));
//        assertThat(numOfClusters.clustersList().get(1).getEndPoint(), is(3));
//
//        assertThat(numOfClusters.clustersList().get(2).getStartPoint(), is(5));
//        assertThat(numOfClusters.clustersList().get(2).getEndPoint(), is(5));
//    }
//
//    @Test
//    public void testMergeList() {
//        List<Integer> l1 = Arrays.asList(new Integer[]{1, 0, 1, 1, 0, 1});
//        List<Integer> l2 = Arrays.asList(new Integer[]{1, 0, 0, 1, 0, 1});
//
//        assertThat( numOfClusters.mergeList(l1, l2), is(Arrays.asList(new Integer[]{1, 0, 1, 1, 0, 1})));
//    }
//
//    @Test
//    public void testFindRegions1() {
//        List<List<Integer>> lists = new ArrayList<>();
//        List<Cluster> expected = Arrays.asList(new Cluster[]{
//                new Cluster(0, 0),
//                new Cluster(2, 3),
//                new Cluster(5, 5)
//        });
//        lists.add(Arrays.asList(new Integer[]{1, 0, 1, 1, 0, 1}));
//
//
//        assertThat(expected, is(numOfClusters.findRegions(lists)));
//    }
//
//    @Test
//    public void testFindRegions2() {
//        List<List<Integer>> lists = new ArrayList<>();
//
//        lists.add(Arrays.asList(new Integer[]{1, 0, 1, 1, 0, 1}));
//        lists.add(Arrays.asList(new Integer[]{1, 0, 0, 1, 0, 1}));
//        lists.add(Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 1}));
//
//        assertThat(numOfClusters.findRegions(lists), is(new Cluster[]{
//                new Cluster(0, 0),
//                new Cluster(2, 3),
//                new Cluster(5, 5)
//        }));
//    }
}
