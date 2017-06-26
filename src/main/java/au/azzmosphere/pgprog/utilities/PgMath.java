package au.azzmosphere.pgprog.utilities;

import java.math.BigInteger;

/**
 * Created by aaron.spiteri on 26/6/17.
 */
public class PgMath {
    public static BigInteger binomialCoefFactorial(BigInteger n, BigInteger k) {
        if (k.equals(n)) {
            return BigInteger.ONE;
        }
        return factorial(n).divide(factorial(k).multiply(factorial(n.subtract(k))));
    }

    public static long binomialCoefFactorial(long n, long k) {
        return binomialCoefFactorial(BigInteger.valueOf(n), BigInteger.valueOf(k)).intValue();
    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger r = n;
        for (BigInteger i = r.subtract(BigInteger.ONE); i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
            r = r.multiply(i);
        }
        return r;
    }

    public static double factorial(double n) {
        return factorial(BigInteger.valueOf((long) n)).doubleValue();
    }

    public static int factorial(int n) {
        return factorial(BigInteger.valueOf(n)).intValue();
    }

    public static BigInteger findLatticePaths(BigInteger m, BigInteger n) {
        return binomialCoefFactorial(m.add(n), n);
    }
}
