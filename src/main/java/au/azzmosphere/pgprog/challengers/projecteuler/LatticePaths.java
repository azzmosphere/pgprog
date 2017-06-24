package au.azzmosphere.pgprog.challengers.projecteuler;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import au.azzmosphere.pgprog.processors.graph.DepthFirstTransverser;
import au.azzmosphere.pgprog.utilities.graph.MatrixBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static au.azzmosphere.pgprog.utilities.graph.ComputeNumNodes.computeSqrNumNodes;
import au.azzmosphere.pgprog.utilities.graph.Node;
import static au.azzmosphere.pgprog.utilities.lists.Clone.cloneArray;

/**
 * Created by aaron.spiteri on 18/6/17.
 */
public class LatticePaths extends DepthFirstTransverser<Boolean> implements ChallengeInterface {
    private static final Logger logger = LoggerFactory.getLogger(DepthFirstTransverser.class);
    private Node<Boolean> startNode, targetNode;
    private int foundPaths = 0;

    @Override
    public void putInput(HashMap inputMap) {
        logger.debug("recieved inputmap " + inputMap);
        String[] dims = ((String) inputMap.get("inputString")).split("x");
        logger.debug("w = " + dims[0] + " h = " + dims[1]);
        List<Boolean> values=new ArrayList<>(Arrays.asList(new Boolean[
                computeSqrNumNodes(Integer.valueOf(dims[0]),
                        Integer.valueOf(dims[1]))
                ]));
        Collections.fill(values, Boolean.TRUE);
        startNode = (new MatrixBuilder<Boolean>()).generateMatrix(Integer.valueOf(dims[1]) + 1,
                Integer.valueOf(dims[0]) + 1, values);

        targetNode = new Node<>();
        targetNode.setId(values.size() - 1);
        targetNode.setValue(values.get(values.size() - 1));
    }

    @Override
    public void process() throws Exception {
        logger.debug("processing");
        transverseMap(startNode, targetNode, new LinkedList<>());
    }

    @Override
    public HashMap returnValues() {
        HashMap<String, String> output = new HashMap<>();
        output.put("outputString", "found " + foundPaths);
        return output;
    }

    @Override
    public void reset() {
        foundPaths = 0;
    }

    @Override
    protected void handleFoundPath(List<Node<Boolean>> foundPath) {
        foundPaths++;
    }

    @Override
    protected List<Node<Boolean>> cloneList(List<Node<Boolean>> list) {
        return cloneArray((LinkedList<Node<Boolean>>) list);
    }
}
