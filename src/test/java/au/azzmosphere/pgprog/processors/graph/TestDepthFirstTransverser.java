package au.azzmosphere.pgprog.processors.graph;

import au.azzmosphere.pgprog.utilities.graph.MatrixBuilder;
import au.azzmosphere.pgprog.utilities.graph.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

import org.junit.Test;

import static au.azzmosphere.pgprog.utilities.graph.ComputeNumNodes.computeSqrNumNodes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 21/6/17.
 */
public class TestDepthFirstTransverser {
    private MatrixBuilder matrixBuilder = new MatrixBuilder();
    private int foundPaths = 0;

//    private DepthFirstTransverser<Boolean> depthFirstTransverser = new DepthFirstTransverser<Boolean>() {
//        @Override
//        protected boolean checkNode(Node n1, Node n2) {
//            return super.checkNode(n1, n2);
//        }
//
//        @Override
//        protected void handleFoundPath(List<Node<Boolean>> foundPath) {
//            foundPaths++;
//        }
//    };

//    @Test
//    public void testTransverseMap() {
//        Boolean[] values = new Boolean[] {false, false, false, false, false, false, false ,false, false};
//        Node<Boolean> n = matrixBuilder.generateMatrix(3, 3, values), targetNode = new Node<>();
//        targetNode.setId(values.length - 1);
//        ArrayList<Node[]> foundPaths = new ArrayList<>();
//        depthFirstTransverser.transverseMap(n, targetNode, foundPaths, new Node[] {});
//
//        assertThat(foundPaths.size(), is(6));
//    }
//
//    @Test
//    public void testTransverseMap2() {
//        List<Boolean> values=new ArrayList<>(Arrays.asList(new Boolean[
//            computeSqrNumNodes(Integer.valueOf(20),
//                Integer.valueOf(20))
//        ]));
//
//        Node<Boolean> startNode = (new MatrixBuilder<Boolean>()).generateMatrix(21, 21, values),
//                targetNode = new Node<>();
//
//        targetNode.setId(values.size() - 1);
//        ArrayList<Node[]> foundPaths = new ArrayList<>();
//        depthFirstTransverser.transverseMap(startNode, targetNode, foundPaths, new Node[] {});
//
//        System.out.println("found paths = " + foundPaths.size());
//    }

//    @Test
//    public void testTransverseMap3() {
//        int w = 20, h = 20;
//        List<Boolean> values=new ArrayList<>(Arrays.asList(new Boolean[
//                computeSqrNumNodes(w, h)]));
//
//        Node<Boolean> startNode = (new MatrixBuilder<Boolean>()).generateMatrix(w + 1, h + 1, values),
//                targetNode = new Node<>();
//
//        targetNode.setId(values.size() - 1);
//        depthFirstTransverser.transverseMap(startNode, targetNode, new LinkedList<>());
//
//        System.out.println("found paths = " + foundPaths);
//    }
}
