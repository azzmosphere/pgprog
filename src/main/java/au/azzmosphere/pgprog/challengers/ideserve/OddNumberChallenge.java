package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron.spiteri on 14/5/17.
 *
 * In an array having positive integers, except for one number which occurs odd number of times, all other numbers occur even number of times. Find the number.
 * Example -
 * Input : 2 5 9 1 5 1 8 2 8
 * Output: 9
 *
 * Input : 2 3 4 3 1 4 5 1 4 2 5
 * Output: 4
 */
public class OddNumberChallenge implements ChallengeInterface {
    private List<Integer> numbers = new ArrayList<>();

    @Override
    public void putInput(HashMap inputMap) {

    }

    @Override
    public void process() throws Exception {

    }

    @Override
    public HashMap returnValues() {
        return null;
    }
}
