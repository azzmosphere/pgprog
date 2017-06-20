package au.azzmosphere.pgprog.challengers.projecteuler;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import au.azzmosphere.pgprog.processors.graph.DepthFirstTransverser;
import au.azzmosphere.pgprog.utilities.graph.MatrixBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static au.azzmosphere.pgprog.utilities.graph.ComputeNumNodes.computeSqrNumNodes;
import au.azzmosphere.pgprog.utilities.graph.Node;

/**
 * Created by aaron.spiteri on 18/6/17.
 */
public class LatticePaths extends DepthFirstTransverser<Boolean> implements ChallengeInterface {
    private static final Logger logger = LoggerFactory.getLogger(DepthFirstTransverser.class);
    private Node<Boolean> startNode, targetNode;
    private ArrayList<ArrayList<Node<Boolean>>> foundPaths = new ArrayList<>();

    @Override
    public void putInput(HashMap inputMap) {
        logger.debug("recieved inputmap " + inputMap);
        String[] dims = ((String) inputMap.get("inputString")).split("x");
        logger.debug("w = " + dims[0] + " h = " + dims[1]);

        Boolean[] values = new Boolean[computeSqrNumNodes(Integer.valueOf(dims[0]),
                Integer.valueOf(dims[1]))];
        startNode = (new MatrixBuilder<Boolean>()).generateMatrix(Integer.valueOf(dims[1]) + 1,
                Integer.valueOf(dims[0]) + 1, new ArrayList<Boolean>(Arrays.asList(values)));

        targetNode = new Node<>();
        targetNode.setId(values.length - 1);
        targetNode.setValue(values[values.length - 1]);
    }

    @Override
    public void process() throws Exception {
        logger.debug("processing");
        transverseMap(startNode, targetNode, foundPaths, new ArrayList<>());
        logger.debug("found paths = " + foundPaths);
    }

    @Override
    public HashMap returnValues() {
        HashMap<String, String> output = new HashMap<>();
        output.put("outputString", "found " + foundPaths.size());
        return output;
    }

    @Override
    public void reset() {

    }
}
