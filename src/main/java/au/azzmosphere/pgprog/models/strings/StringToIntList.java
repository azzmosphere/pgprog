package au.azzmosphere.pgprog.models.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a list of Integers from a string
 * Created by aaron.spiteri on 15/5/17.
 */
public class StringToIntList {
    public static final List<Integer> createIntegerList(String s) {
        Logger logger = LoggerFactory.getLogger(StringToIntList.class);
        List<Integer> numbers = new ArrayList<>();

        String[] numberArray = s.split("( +|\\n|,)");

        for (String n : numberArray) {
            Integer k;

            try {
                k = Integer.valueOf(n);
            }
            catch (NumberFormatException e) {

                // Skip this line.
                logger.warn("'" + n + "' is not a positive integer, going to skip " + e.getMessage());
                continue;
            }
            numbers.add(k);
        }

        return numbers;
    }
}
