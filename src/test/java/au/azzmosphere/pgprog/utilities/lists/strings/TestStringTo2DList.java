package au.azzmosphere.pgprog.utilities.lists.strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 26/5/17.
 */
public class TestStringTo2DList {
    private StringTo2DList<Integer> stringTo2DList = new StringTo2DList<>();

    @Test
    public void testStringTo2DList1() throws Exception {
        String s = "1,0,1,0,1 \n" + "1,1,0,0,0\n" + "0,1,0,1,1";
        List<List<Integer>> l = new ArrayList<>();

        l.add(Arrays.asList(new Integer[]{1, 0, 1, 0, 1}));
        l.add(Arrays.asList(new Integer[]{1, 1, 0, 0, 0}));
        l.add(Arrays.asList(new Integer[]{0, 1, 0, 1, 1}));

        List<List<Integer>> y =  stringTo2DList.create2DList(s, Integer.class);

        assertThat(l, is(y));
    }
}
