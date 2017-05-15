package au.azzmosphere.pgprog.challengers;

import java.util.HashMap;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public interface ChallengeInterface {
    void putInput(HashMap inputMap);
    void process() throws Exception;
    HashMap returnValues();
    void reset();
}
