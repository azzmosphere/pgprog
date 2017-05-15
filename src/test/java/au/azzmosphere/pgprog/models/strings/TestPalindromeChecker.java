package au.azzmosphere.pgprog.models.strings;

import org.junit.Test;

import static au.azzmosphere.pgprog.models.strings.PalindromeChecker.isPalindrome;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 15/5/17.
 */
public class TestPalindromeChecker {
    @Test
    public void checkIsPalindrome1() {
        assertThat(isPalindrome("dodd"), is(false));
        assertThat(isPalindrome("dod"), is(true));
        assertThat(isPalindrome("dood"), is(true));
        assertThat(isPalindrome("dodod"), is(true));
        assertThat(isPalindrome("dododo"), is(false));
        assertThat(isPalindrome("anana"), is(true));

    }
}
