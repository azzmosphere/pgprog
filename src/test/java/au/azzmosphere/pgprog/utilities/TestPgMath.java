package au.azzmosphere.pgprog.utilities;

import org.junit.Test;

import java.math.BigInteger;

import static au.azzmosphere.pgprog.utilities.PgMath.factorial;
import static au.azzmosphere.pgprog.utilities.PgMath.binomialCoefFactorial;
import static au.azzmosphere.pgprog.utilities.PgMath.findLatticePaths;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 25/6/17.
 */

public class TestPgMath {

    @Test
    public void testFactorial() {
        assertThat(factorial(2), is(2));
        assertThat(factorial(3), is(6));
        assertThat(factorial(9), is(362880));
        assertThat(factorial(5), is(120));
    }

    @Test
    public void testBinomialCoefFactorial() {
        assertThat(binomialCoefFactorial(4, 2), is(6L));
    }

    @Test
    public void testLattice() {
        assertThat(findLatticePaths(BigInteger.valueOf(2), BigInteger.valueOf(2)).intValue(), is(6));
        assertThat(findLatticePaths(BigInteger.valueOf(8), BigInteger.valueOf(8)).intValue(), is(12870));
    }
}

