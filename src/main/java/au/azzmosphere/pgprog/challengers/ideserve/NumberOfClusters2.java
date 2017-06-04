package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.ArrayList;

import static au.azzmosphere.pgprog.utilities.lists.strings.StringTo2DIntList.createInteger2DList;

public class NumberOfClusters2 implements ChallengeInterface {
    private static final Logger logger = LoggerFactory.getLogger(NumberOfClusters2.class);
    private static final int[] offsets = {-1, 0, +1};
    private int[][] matrix;
    private int count;

    private boolean neighborExists(int[][] matrix, int i, int j) {
        if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length)) {
            if (matrix[i][j] == 1) {
                return true;
            }
        }

        return false;
    }

    private void doDFS(int[][] matrix, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        int xOffset, yOffset;
        for (int l = 0; l < offsets.length; l++) {
            xOffset = offsets[l];
            for (int m = 0; m < offsets.length; m++) {
                yOffset = offsets[m];


                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }


                if (neighborExists(matrix, i + xOffset, j + yOffset)) {
                    doDFS(matrix, i + xOffset, j + yOffset, visited);
                }
            }
        }
    }

    public int findNumberofClusters(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((matrix[i][j] == 1) && (!visited[i][j])) {

                    count += 1;
                    doDFS(matrix, i, j, visited);
                }
            }
        }
        return count;
    }

    @Override
    public void putInput(HashMap inputMap) {
        String inputString = (String) inputMap.get("inputString");
        ArrayList<ArrayList<Integer>> list;

        try {
            list = (ArrayList) createInteger2DList(inputString);
            matrix = new int[list.size()][list.get(0).size()];
            for (int x = 0; x < list.size(); x++) {
                for (int y = 0; y < list.get(x).size(); y++) {
                    matrix[x][y] = list.get(x).get(y);
                }
            }
        } catch (Exception e) {
            logger.error("could not create 2D list");
        }
    }

    @Override
    public void process() throws Exception {
        count = findNumberofClusters(matrix);
    }

    @Override
    public HashMap returnValues() {
        HashMap<String, Integer> rv = new HashMap<>();
        rv.put("outputString", count);
        return rv;
    }

    @Override
    public void reset() {

    }
}

