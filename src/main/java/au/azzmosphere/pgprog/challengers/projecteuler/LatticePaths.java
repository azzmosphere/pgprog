package au.azzmosphere.pgprog.challengers.projecteuler;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import au.azzmosphere.pgprog.processors.graph.DepthFirstTransverser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.HashMap;


import static au.azzmosphere.pgprog.utilities.PgMath.findLatticePaths;


/**
 * Created by aaron.spiteri on 18/6/17.
 */
public class LatticePaths  implements ChallengeInterface {
    private static final Logger logger = LoggerFactory.getLogger(DepthFirstTransverser.class);
    BigInteger m, n, foundPaths;

    @Override
    public void putInput(HashMap inputMap) {
        logger.debug("recieved inputmap " + inputMap);
        String[] dims = ((String) inputMap.get("inputString")).split("x");
        logger.debug("m = " + dims[0] + " n = " + dims[1]);
        m = BigInteger.valueOf(Integer.valueOf(dims[0]));
        n = BigInteger.valueOf(Integer.valueOf(dims[1]));
        logger.debug("paths have been mapped");
    }

    @Override
    public void process() throws Exception {
        logger.debug("processing");
        foundPaths = findLatticePaths(m, n);
        logger.info("found :" + foundPaths.toString() + " paths");
    }

    @Override
    public HashMap returnValues() {
        HashMap<String, String> output = new HashMap<>();
        output.put("outputString", "found " + foundPaths.toString());
        return output;
    }

    @Override
    public void reset() {
        foundPaths = BigInteger.ZERO;
    }
}
