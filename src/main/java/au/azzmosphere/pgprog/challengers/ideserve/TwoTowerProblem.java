package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;

import java.util.ArrayList;
import java.util.HashMap;

import static au.azzmosphere.pgprog.models.strings.StringToIntList.createIntegerList;

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

    @Override
    public void putInput(HashMap inputMap) {
        towers = (ArrayList) createIntegerList((String) inputMap.get("towers"));
    }

    @Override
    public void process() throws Exception {

    }

    @Override
    public HashMap returnValues() {
        return null;
    }

    @Override
    public void reset() {

    }
}
