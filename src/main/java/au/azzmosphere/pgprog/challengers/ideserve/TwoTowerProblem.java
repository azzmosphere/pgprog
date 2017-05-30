package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static au.azzmosphere.pgprog.utilities.lists.strings.StringToIntList.createIntegerList;

/**
 * We have an array where each element represents height of a tower. If it starts raining,
 * what is the amount of water that can be collected between the towers? Assumption is that the width of every tower is 1.
 * Example:
 * Input  - {1,5,2,3,1,7,2,4}
 * Output - 11
 *
 * Created by aaron.spiteri on 18/5/17.
 */
public class TwoTowerProblem implements ChallengeInterface {
    private ArrayList<Integer> towers;
    private int t1, t2;
    private HashMap<String, Integer> rv = new HashMap<>();

    public ArrayList<Integer> getTowers() {
        return towers;
    }

    public void setTowers(ArrayList<Integer> towers) {
        this.towers = towers;
    }

    public int getT1() {
        return t1;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public int getT2() {
        return t2;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }

    @Override
    public void putInput(HashMap inputMap) {
        towers = (ArrayList) createIntegerList((String) inputMap.get("inputString"));
    }

    @Override
    public void process() throws Exception {
        findLargestNodes();
        rv.put("outputString", volume(maxVolume()));
    }

    @Override
    public HashMap returnValues() {
        return rv;
    }

    @Override
    public void reset() {
        towers = null;
    }

    /**
     * for all integers in array towers find nodes that have the largest
     * positive values where edges between both nodes is greater than 1.
     *
     * set t1 and t2 as the resultant indices of this find.
     */
    protected final void findLargestNodes() {
        Object[] a = (Object[]) towers.toArray();
        Arrays.sort(a);

        int a1 = findIndexInArray((int) a[towers.size() - 1]),
                a2 = findIndexInArray((int) a[towers.size() - 2]);

        setT1((a1 < a2) ? a1 : a2);
        setT2((a1 > a2) ? a1 : a2);
    }

    /**
     * once t1 and t2 are set return the maximum volume that
     * can be contained between these two points.
     *
     * @return maxVolume
     */
    protected final int maxVolume() {
        int h = (towers.get(t1) > towers.get(t2)) ? towers.get(t2) : towers.get(t1),
            d = t2 - (t1 + 1);
        return h * d;
    }

    private int findIndexInArray(int value) {
        for (int i = 0; i < towers.size(); i++) {
            if (value == towers.get(i)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * given the maximum volume, offset it by the
     * variance within the distance form t1 to t2.
     *
     * @param maxVolume
     * @return volume
     */
    protected final int volume(int maxVolume) {
        int volume = maxVolume;
        for (int i = (t1 + 1); i < t2; i++) {
            volume -= towers.get(i);
        }

        return volume;
    }
}
