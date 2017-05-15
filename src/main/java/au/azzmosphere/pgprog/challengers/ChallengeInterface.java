package au.azzmosphere.pgprog.challengers;

import java.util.HashMap;

/**
 * Each challenge must comply to this interface which controls
 * the way the challenge will communicate back to the interface.
 *
 * Created by aaron.spiteri on 14/5/17.
 */
public interface ChallengeInterface {

    /**
     * hashmap that contains the inputs sent in the PUT request
     *
     * @param inputMap
     */
    void putInput(HashMap inputMap);

    /**
     * triggers the challenge to do any heavy lifting.
     * @throws Exception
     */
    void process() throws Exception;

    /**
     * The result of processing.
     *
     * @return
     */
    HashMap returnValues();

    /**
     * perform any clean up work that ensures each run will not be affected
     * by the last one.
     */
    void reset();
}
