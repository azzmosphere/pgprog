package au.azzmosphere.pgprog.models.strings;

/**
 * Created by aaron.spiteri on 15/5/17.
 *
 * Checks to see if a a String is a palindrome
 */
public class PalindromeChecker {

    /**
     * Returns true if the string is a a palindrome
     * @param s
     * @return
     */
    public static final boolean isPalindrome(String s) {
        int x = s.length() / 2;

        for (int i = 0; i < x; i++) {
            if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }
}
