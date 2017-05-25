package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.Map;

import static au.azzmosphere.pgprog.models.strings.StringToIntList.createIntegerList;

/**
 * Created by aaron.spiteri on 14/5/17.
 *
 * In an array having positive integers, except for one number which occurs odd number of times,
 * all other numbers occur even number of times. Find the number.
 * Example -
 * Input : 2 5 9 1 5 1 8 2 8
 * Output: 9
 *
 * Input : 2 3 4 3 1 4 5 1 4 2 5
 * Output: 4
 */
public class OddNumberChallenge implements ChallengeInterface {
    private List<Integer> numbers = new ArrayList<>();
    private HashMap<String, Integer> rv = new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(OddNumberChallenge.class);

    @Override
    public void putInput(HashMap inputMap) {
        numbers = createIntegerList((String) inputMap.get("inputString") );
    }

    @Override
    public void process() throws Exception {
        HashMap<Integer, Integer> instanceCount = new HashMap<>();

        for (Integer i : numbers) {
            if (instanceCount.containsKey(i)) {
                instanceCount.put(i, instanceCount.get(i).intValue() + 1);
            }
            else {
                instanceCount.put(i, 1);
            }
        }

        Iterator it = instanceCount.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if ((((Integer) pair.getValue()) % 2) != 0) {
                rv.put("outputString", (Integer) pair.getKey());
                break;
            }
        }
    }

    @Override
    public HashMap returnValues() {
        return rv;
    }

    @Override
    public void reset() {
        numbers = new ArrayList<>();
        rv = new HashMap<>();
    }
}
