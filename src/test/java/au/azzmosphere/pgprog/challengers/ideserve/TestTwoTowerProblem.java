package au.azzmosphere.pgprog.challengers.ideserve;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
/**
 * Created by aaron.spiteri on 19/5/17.
 */
public class TestTwoTowerProblem {
    private TwoTowerProblem twoTowerProblem = new TwoTowerProblem();

    @Test
    public void testFindLargestNodes1() {
        ArrayList<Integer> array =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{3,1,2}));
        twoTowerProblem.setTowers(array);

        twoTowerProblem.findLargestNodes();
        assertThat(twoTowerProblem.getT1(), is(0));
        assertThat(twoTowerProblem.getT2(), is(2));
    }

    @Test
    public void testFindLargestNodes2() {
        ArrayList<Integer> array =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{4,1,2,2,3}));
        twoTowerProblem.setTowers(array);

        twoTowerProblem.findLargestNodes();
        assertThat(twoTowerProblem.getT1(), is(0));
        assertThat(twoTowerProblem.getT2(), is(4));
    }

    @Test
    public void testFindLargestNodes3() {
        ArrayList<Integer> array =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{1,5,2,2,3,7}));
        twoTowerProblem.setTowers(array);

        twoTowerProblem.findLargestNodes();
        assertThat(twoTowerProblem.getT1(), is(1));
        assertThat(twoTowerProblem.getT2(), is(5));
    }

    @Test
    public void testMaxVolume1() {
        ArrayList<Integer> array =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{3,1,2}));
        twoTowerProblem.setTowers(array);
        twoTowerProblem.findLargestNodes();
        assertThat(twoTowerProblem.maxVolume(), is(2));
    }

    @Test
    public void testMaxVolume2() {
        ArrayList<Integer> array =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{1,5,2,2,3,7}));
        twoTowerProblem.setTowers(array);
        twoTowerProblem.findLargestNodes();
        assertThat(twoTowerProblem.maxVolume(), is(15));
    }

    @Test
    public void testMaxVolume3() {
        ArrayList<Integer> array =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{4,1,2,2,3}));
        twoTowerProblem.setTowers(array);
        twoTowerProblem.findLargestNodes();
        assertThat(twoTowerProblem.maxVolume(), is(9));
    }

    @Test
    public void testVolume1() {
        ArrayList<Integer> array =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{3,1,2}));
        twoTowerProblem.setTowers(array);
        twoTowerProblem.findLargestNodes();
        assertThat( twoTowerProblem.volume(twoTowerProblem.maxVolume()), is(1));
    }

    @Test
    public void testVolume2() {
        ArrayList<Integer> array =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{4,1,2,2,3}));
        twoTowerProblem.setTowers(array);
        twoTowerProblem.findLargestNodes();
        assertThat( twoTowerProblem.volume(twoTowerProblem.maxVolume()), is(4));
    }
}
