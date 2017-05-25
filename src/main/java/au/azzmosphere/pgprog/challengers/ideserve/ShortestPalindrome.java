package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import static au.azzmosphere.pgprog.models.strings.PalindromeChecker.isPalindrome;
/**
 * Given a string s, form a shortest palindrome by appending characters at the start of the string.
 * Example: abab => babab. abcd => dcbabcd. ananab    => bananab.
 *
 * Created by aaron.spiteri on 15/5/17.
 */
public class ShortestPalindrome implements ChallengeInterface {
    private String palindromeString = null;
    private final Logger logger = LoggerFactory.getLogger(OddNumberChallenge.class);

    @Override
    public void putInput(HashMap inputMap) {
        this.palindromeString = (String) inputMap.get("inputString");
    }

    @Override
    public void process() throws Exception {
        String palindromeString = this.palindromeString;

        // Could be lucky
        if (isPalindrome(palindromeString)) {
            return;
        }

        // check for sub palindrome.
        String postString = "";
        for (int i = (palindromeString.length() - 1); i > 0; i --) {
            postString = postString + palindromeString.charAt(palindromeString.length() - 1);
            palindromeString = palindromeString.substring(0, palindromeString.length() - 1);

            if (isPalindrome(palindromeString)) {
                logger.debug("sub palindrome string " + palindromeString + " found");
                break;
            }
        }

        this.palindromeString = postString + this.palindromeString;
    }

    @Override
    public HashMap returnValues() {
        HashMap<String, String> rv = new HashMap<>();
        rv.put("outputString", palindromeString);
        return rv;
    }

    @Override
    public void reset() {
        palindromeString = null;
    }
}
