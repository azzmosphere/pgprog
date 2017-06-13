package au.azzmosphere.pgprog.challengers.ideserve;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.ArrayList;

import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialInsert;
import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialDelete;
import static au.azzmosphere.pgprog.challengers.ideserve.minreachsrcdestword.Trial.trialSubstitute;

/**
 * Created by aaron.spiteri on 31/5/17.
 */
public class MinReachSrcDestWord implements ChallengeInterface {
    private int startword, endword;
    private String outputString;
    private String[] dictionaryArray;
    private static final Logger logger = LoggerFactory.getLogger(MinReachSrcDestWord.class);

    public int getStartword() {
        return startword;
    }

    public void setStartword(int startword) {
        this.startword = startword;
    }

    public int getEndword() {
        return endword;
    }

    public void setEndword(int endword) {
        this.endword = endword;
    }

    public String getOutputString() {
        return outputString;
    }

    public void setOutputString(String outputString) {
        this.outputString = outputString;
    }

    public String[] getDictionaryArray() {
        return dictionaryArray;
    }

    public void setDictionaryArray(String[] dictionaryArray) {
        this.dictionaryArray = dictionaryArray;
    }

    @Override
    public void putInput(HashMap inputMap) {
        logger.debug("inputMap = " + inputMap.toString());
        dictionaryArray = ((String) inputMap.get("dictonary")).split(",");
        startword = Integer.valueOf((String) inputMap.get("startword"));
        endword = Integer.valueOf((String) inputMap.get("endword"));

        logger.debug("dictionaryArray = " + dictionaryArray + ", startword = " + startword + " endword = " + endword);
    }

    @Override
    public void process() throws Exception {
        outputString = "-1";

        if (startword > endword) {
            return;
        }
        else if (startword == endword) {
            outputString = dictionaryArray[startword];
            return;
        }

        else if (trialMatch(dictionaryArray[startword], dictionaryArray[endword])) {
            outputString = dictionaryArray[startword] + "->" +  dictionaryArray[endword];
            return;
        }

        ArrayList found = seekTrails(startword, endword, new ArrayList());
        outputString = dictionaryArray[startword];
        for (Object o : found) {
            outputString += "->" + o;
        }

    }

    public ArrayList seekTrails(int s1i, int s2i, ArrayList found) {
        if (trialMatch(dictionaryArray[s1i], dictionaryArray[s2i])) {
            found.add(dictionaryArray[s2i]);
            return found;
        }

        for (int i = (s1i + 1); i < s2i; i++) {
            if (trialMatch(dictionaryArray[i], dictionaryArray[s1i])) {
                found.add(dictionaryArray[i]);
                return seekTrails(i, s2i, found);
            }
        }

        return null;
    }

    protected ArrayList clone(ArrayList a1) {
        ArrayList a2 = new ArrayList();
        for (Object i : a1) {
            a2.add(i);
        }
        return a2;
    }

    protected boolean trialMatch(String s1, String s2) {
        if (trialInsert(s1, s2) || trialDelete(s1, s2) || trialSubstitute(s1, s2)) {
            return true;
        }
        return false;
    }

    @Override
    public HashMap returnValues() {
        HashMap<String, String> output = new HashMap<>();
        output.put("outputString", outputString);
        return output;
    }

    @Override
    public void reset() {
        dictionaryArray = null;
        startword = 0;
        endword = 0;
    }
}
