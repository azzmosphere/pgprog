package au.azzmosphere.pgprog.utilities.lists.strings;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aaron.spiteri on 26/5/17.
 */
public class ValueOfThing<Y, I> {
    private Logger logger = LoggerFactory.getLogger(ValueOfThing.class);

    public Y valueOf(I thing, Class wrapperClass) throws Exception {
        Y result = null;
        try {
            Method method = wrapperClass.getMethod("valueOf", thing.getClass());
            result = (Y) method.invoke(wrapperClass, thing);
        }
        catch (Exception e) {
            logger.error("could not get valueOf for " + thing);
            throw e;
        }

        return result;
    }
}
