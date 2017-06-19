package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import au.azzmosphere.pgprog.processors.graph.DepthFirstTransverser;
import au.azzmosphere.pgprog.utilities.graph.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;

import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialInsert;
import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialDelete;
import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialSubstitute;
import static au.azzmosphere.pgprog.utilities.lists.Clone.cloneArray;
/**
 * Created by aaron.spiteri on 13/6/17.
 */
public class MinReachSrcDestWordGraph extends DepthFirstTransverser implements ChallengeInterface {
    private Hashtable<Integer, Node<String>> nodeMap = new Hashtable<>();
    private static final Logger logger = LoggerFactory.getLogger(MinReachSrcDestWordGraph.class);
    private ArrayList<ArrayList<Node<String>>> foundPaths = new ArrayList<>();
    private Node<String> startNode, targetNode;
    private String outputString = "-1";

    private static final int START_VALUE = 100000000;

    @Override
    public void putInput(HashMap inputMap) {
        logger.debug("inputMap = " + inputMap.toString());
        createNodeMap(((String) inputMap.get("dictonary")).split(","));
        startNode = nodeMap.get(Integer.valueOf((String) inputMap.get("startword")));
        targetNode = nodeMap.get(Integer.valueOf((String) inputMap.get("endword")));
    }

    protected void createNodeMap(String[] dictionaryArray ) {
        for (int i = 0;i < dictionaryArray.length; i ++) {
            if (!nodeMap.containsKey(i)) {
                nodeMap.put(i, new Node<>());
                nodeMap.get(i).setId(i);
                nodeMap.get(i).setValue(dictionaryArray[i]);
            }
            appendMap(dictionaryArray, nodeMap.get(i));
        }

        logger.debug("nodeMap is graphed to " + nodeMap);
    }

    @Override
    public void process() throws Exception {
        transverseMap(startNode, targetNode, foundPaths, new ArrayList<>());

        // for each found path get the shortest.
        // set to a large size to start with
        int s = START_VALUE, r = START_VALUE;
        for (int i = 0; i < foundPaths.size(); i++) {
            ArrayList<Node<String>> p = foundPaths.get(i);
            if (p.size() < s) {
                s = p.size();
                r = i;
            }
        }

        if (r != START_VALUE) {
            ArrayList<Node<String>> p = foundPaths.get(r);
            outputString = "";

            for (Node<String> n : p) {
                outputString += n.getValue() + "->";
            }

            outputString = outputString.substring(0, outputString.length() -2);
        }
    }

    @Override
    public HashMap returnValues() {
        HashMap<String, String> output = new HashMap<>();
        output.put("outputString", outputString);
        return output;
    }

    @Override
    public void reset() {
        outputString = "-1";
        startNode = null;
        targetNode = null;
    }

    public void appendMap(String[] dictionaryArray, Node<String> n) {
        String s1 = n.getValue();
        int i = n.getId();
        for (int y = 0; y < dictionaryArray.length; y++) {
            if (y == i) {
                continue;
            }
            String s2 = dictionaryArray[y];
            if (trialInsert(s1, s2) || trialDelete(s1, s2) || trialSubstitute(s1, s2)) {
                Node n2;
                if (nodeMap.containsKey(y)) {
                    n2 = nodeMap.get(y);
                }
                else {
                    n2 = new Node();
                    n2.setValue(s2);
                    n2.setId(y);
                    nodeMap.put(y, n2);
                }
                n.addEdge(n2);
            }
        }
    }

}
