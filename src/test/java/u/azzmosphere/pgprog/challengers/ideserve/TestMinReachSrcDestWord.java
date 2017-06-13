package u.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ideserve.MinReachSrcDestWord;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
/**
 * Created by aaron.spiteri on 13/6/17.
 */
public class TestMinReachSrcDestWord {
    private MinReachSrcDestWord object = new MinReachSrcDestWord();

    @Before
    public void setUpObject() {
        object.setDictionaryArray(new String[] {"BCCI", "AICC", "ICC", "CCI", "MCC", "MCA", "ACC"});
    }

    @Test
    public void testseekTrails1() {

        ArrayList a = new ArrayList();
        a.add("ICC");

        assertThat(object.seekTrails(1,2, new ArrayList()), is(a));
    }

    @Test
    public void testseekTrails2() {
        ArrayList a = new ArrayList();
        a.add("ICC");
        a.add("MCC");
        assertThat(object.seekTrails(1,4, new ArrayList()), is(a));
    }

    @Test
    public void testseekTrails3() {
        // "AICC" to "MCA" is 3(AICC->ICC->MCC->MCA).
        ArrayList a = new ArrayList();
        a.add("ICC");
        a.add("MCC");
        a.add("MCA");
        assertThat(object.seekTrails(1,5, new ArrayList()), is(a));
    }
}
