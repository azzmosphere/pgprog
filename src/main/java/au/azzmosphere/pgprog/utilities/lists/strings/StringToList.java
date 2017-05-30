package au.azzmosphere.pgprog.utilities.lists.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a list of Integers from a string
 * Created by aaron.spiteri on 15/5/17.
 */
public class StringToList<Y> {
    private final Logger logger = LoggerFactory.getLogger(StringToList.class);

    public final List<Y> createList(String s, Class wrapperClass) {

        List<Y> numbers = new ArrayList<>();
        ValueOfThing<Y, String> valueOfThing = new ValueOfThing<>();

        String[] numberArray = s.split("( +|\\n|,)");

        for (String n : numberArray) {
            Y k;

            try {
                k = valueOfThing.valueOf(n, wrapperClass);
            }
            catch (Exception e) {

                // Skip this line.
                logger.warn("'" + n + "' is invalid, going to skip " + e.getMessage());
                continue;
            }
            numbers.add(k);
        }

        return numbers;
    }
}
