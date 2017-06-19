package au.azzmosphere.pgprog.utilities.lists;

/**
 * Created by aaron.spiteri on 19/6/17.
 */
public class ComputeNumNodes {
    /**
     * given the height and width of a closed graph, constructed of
     * ajoining squares, where a square is defined as a polygon with
     * four sides that are all 90 degrees, then return the number of
     * nodes within the graph.
     *
     *
     * @param width - how many squares wide
     * @param height - how many squares high
     * @return
     */
    public static int computeSqrNumNodes(int width, int height) {
        return (height + 1) * (width + 1);
    }
}
