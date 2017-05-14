package au.azzmosphere.pgprog.controllers;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;

import java.util.HashMap;

/**
 * Created by aaron.spiteri on 15/5/17.
 */
public abstract class ControllerBase {
    private ChallengeInterface challenge;

    public ChallengeInterface getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeInterface challenge) {
        this.challenge = challenge;
    }

    protected final HashMap process(HashMap input) {
        HashMap rv = null;
        try {
            challenge.putInput(input);
            challenge.process();
            rv = challenge.returnValues();
        }
        catch (Exception e) {
            if (rv == null) {
                rv = new HashMap<>();
            }
            rv.put("lastError", "ERROR: " + e.getMessage());
        }
        return rv;
    }
}
