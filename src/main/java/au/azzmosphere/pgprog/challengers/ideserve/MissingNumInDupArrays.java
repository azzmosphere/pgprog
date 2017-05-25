package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.HashMap;

import static au.azzmosphere.pgprog.models.strings.StringToIntList.createIntegerList;

/**
 * Created by aaron.spiteri on 15/5/17.
 */
public class MissingNumInDupArrays implements ChallengeInterface {

    private final Logger logger = LoggerFactory.getLogger(OddNumberChallenge.class);
    private List<Integer> a1, a2;
    private HashMap<String, Integer> rv = new HashMap<>();


    @Override
    public void putInput(HashMap inputMap) {
        logger.debug("creating input arrays for comparison");
        a1 = createIntegerList((String) inputMap.get("a1"));
        a2 = createIntegerList((String) inputMap.get("a2"));
    }

    @Override
    public void process() throws Exception {
        List<Integer> a = (a1.size() > a2.size()) ? a1 : a2, b = (a1.size() > a2.size()) ? a2 : a1;

        for (Integer i : a) {
            if (!b.contains(i)) {
                rv.put("answer" , i);
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
        a1 = null;
        a2 = null;
    }
}
