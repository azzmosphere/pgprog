package au.azzmosphere.pgprog.utilities.lists.strings;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 26/5/17.
 */
public class TestValueOfThing {

    @Test
    public void testValueOfInteger() throws Exception {
        ValueOfThing<Integer, String> t = new ValueOfThing();

        Integer x  = t.valueOf("5", Integer.class);
        assertThat(x, is(5));
    }

}
