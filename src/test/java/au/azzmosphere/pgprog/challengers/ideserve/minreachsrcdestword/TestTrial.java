package au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword;

import org.junit.Test;

import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialInsert;
import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialDelete;
import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialSubstitute;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 8/6/17.
 */
public class TestTrial {
    @Test
    public void testTrialInsert() {
        String w = "ICC", w2 = "MICC";

        assertThat(trialInsert(w, w2), is(true));

        w = "ICC";
        w2 = "ICCM";
        assertThat(trialInsert(w, w2), is(true));

        w = "IIICC";
        w2 = "ICCM";
        assertThat(trialInsert(w, w2), is(false));
    }

    @Test
    public void testTrialDelete() {
        String w = "ICC", w2 = "MICC";

        assertThat(trialDelete(w2, w), is(true));

        w = "ICC";
        w2 = "ICCM";
        assertThat(trialDelete(w2, w), is(true));

        w = "IIICC";
        w2 = "ICCM";
        assertThat(trialDelete(w2, w), is(false));
    }

    @Test
    public void testTrialSubstitute() {
        String w = "MCC", w1 = "ACC";

        assertThat(trialSubstitute(w, w1), is(true));

        w1 = "ACD";
        assertThat(trialSubstitute(w, w1), is(false));

    }
}
