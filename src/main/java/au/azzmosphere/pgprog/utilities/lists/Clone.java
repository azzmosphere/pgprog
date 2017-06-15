package au.azzmosphere.pgprog.utilities.lists;

import java.util.ArrayList;

/**
 * Created by aaron.spiteri on 14/6/17.
 */
public class Clone {
    public static ArrayList cloneArray(ArrayList a1) {
        ArrayList a2 = new ArrayList();
        for (Object i : a1) {
            a2.add(i);
        }
        return a2;
    }
}
