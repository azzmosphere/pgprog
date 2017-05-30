package au.azzmosphere.pgprog.utilities.lists.strings;

import au.azzmosphere.pgprog.utilities.lists.strings.StringToList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
/**
 * Created by aaron.spiteri on 26/5/17.
 */
public class TestStringToList {

    @Test
    public void testStringToList1() {
        StringToList<Integer> stringToList = new StringToList<>();
        List<Integer> l = Arrays.asList(new Integer[]{1,2,3,4});
        List<Integer> y = stringToList.createList("1 2 3 4", Integer.class);

        assertThat(l, is(y));
    }
}
