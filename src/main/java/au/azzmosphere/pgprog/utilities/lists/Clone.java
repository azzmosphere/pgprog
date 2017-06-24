package au.azzmosphere.pgprog.utilities.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aaron.spiteri on 14/6/17.
 */
public class Clone {
    public static ArrayList cloneArray(ArrayList a1) {
        return (ArrayList) cloneNewList(a1, new ArrayList());
    }

    public static LinkedList cloneArray(LinkedList a1) {
        return (LinkedList) cloneNewList(a1, new LinkedList());
    }

    public static List cloneArray(List a1, Object a2o) {
        List a2 = (List) a2o;
        return cloneNewList(a1, a2);
    }

    private static List cloneNewList(List a1, List a2) {
        for (Object i : a1) {
            a2.add(i);
        }
        return a2;
    }


}
