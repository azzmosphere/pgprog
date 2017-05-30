package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import au.azzmosphere.pgprog.challengers.ideserve.numofclusters.Cluster;
import au.azzmosphere.pgprog.challengers.ideserve.numofclusters.Node;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static au.azzmosphere.pgprog.utilities.lists.strings.StringTo2DIntList.createInteger2DList;
/**
 * Created by aaron.spiteri on 25/5/17.
 */
public class NumOfClusters implements ChallengeInterface {
    private List<List<Integer>> list;
    private static final Logger logger = LoggerFactory.getLogger(ChallengeInterface.class);

    public List<Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    private List<Cluster> clusters = new ArrayList<>();

    @Override
    public void putInput(HashMap inputMap) {
        String inputString = (String) inputMap.get("inputString");

        try {
            list = createInteger2DList(inputString);
        } catch (Exception e) {
            logger.error("could not create 2D list");
        }
    }

    @Override
    public void process() throws Exception {
        for (int y = 0; y < list.size(); y++) {
            List<Integer> row = list.get(y);
            for (int x = 0; x < row.size(); x++) {
                outerloop:
                if (row.get(x) > 0) {
                    Node node = new Node(x, y, row.get(x));
                    for (Cluster cluster : clusters) {
                        if (cluster.checkNode(node)) {
                            cluster.addNode(node);
                            break outerloop;
                        }
                    }

                    clusters.add(new Cluster());
                    clusters.get(clusters.size() - 1).addNode(node);
                }
            }
        }
        prunClusters();
    }

    @Override
    public HashMap returnValues() {
        HashMap<String, Integer> rv = new HashMap<>();
        rv.put("outputString", clusters.size());
        return rv;
    }

    @Override
    public void reset() {
        list = new ArrayList<>();
        clusters = new ArrayList<>();
    }

    protected void prunClusters() {
        List<Integer> clustersToRemove = new ArrayList<>();
        for (int y = 1; y < clusters.size(); y++) {
            Cluster t = clusters.get(y);

            for (int x = 0; x < y; x++) {
                for (Node n : clusters.get(x).getNodes()) {
                    if (t.checkNode(n)) {
                        t.mergeCluster(clusters.get(x));
                        clustersToRemove.add(x);
                        break;
                    }
                }
            }
        }

        logger.debug("found " + clustersToRemove.size() + " that can be pruned");
        for (int x = clustersToRemove.size() - 1; x  >= 0; x--) {
            clusters.remove(x);
        }
    }
}

