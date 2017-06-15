package au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword;

/**
 * A valid trail on word w is  defined as either insert, delete or substitute
 * operation of a single character in word 'w' which results in a word 'w1'
 *
 * Created by aaron.spiteri on 8/6/17.
 */
public class Trial {
    /**
     * if a character was to be inserted in word "w" return true if it would
     * result in the word becommming w1.
     *
     * @param w
     * @param w1
     * @return
     */
    public static boolean trialInsert(String w, String w1) {

        if (!(w.length() > 1 && w1.length() > 1)) {
            return false;
        }

        for (int i = 0; i < w1.length(); i++) {
            if ((w1.substring(0, i) + w1.substring(i + 1)).equals(w)) {
                return true;
            }
        }
        return false;
    }

    public static boolean trialDelete(String w, String w1) {
        return trialInsert(w1, w);
    }

    public static boolean trialSubstitute(String w, String w1) {
        if (w1.length() != w.length()) {
            return false;
        }

        int i = 0, t = 0;
        for (char c : w1.toCharArray()) {
            if (w.charAt(i) != c) {
                t++;

                if (t > 1) {
                    return false;
                }
            }
            i++;
        }

        return true;
    }
}
