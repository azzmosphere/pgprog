package au.azzmosphere.pgprog.utilities.lists.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Create a list of Integers from a string
 * Created by aaron.spiteri on 15/5/17.
 */
public class StringToIntList {
    private static final Logger logger = LoggerFactory.getLogger(StringToIntList.class);

    public static final List<Integer> createIntegerList(String s) {
        List<Integer> numbers = null;

        StringToList<Integer> stringToList = new StringToList<>();
        try {
            numbers = stringToList.createList(s, Integer.class);
        }
        catch (Exception e) {
            logger.error("exception caught " + e.getMessage());
        }

        return numbers;
    }
}
