package au.azzmosphere.pgprog.utilities.lists.strings;

import java.util.List;

/**
 * Created by aaron.spiteri on 26/5/17.
 */
public class StringTo2DIntList {
    public static List<List<Integer>> createInteger2DList(String s) throws Exception {
        return (new StringTo2DList<Integer>()).create2DList(s, Integer.class);
    }
}
