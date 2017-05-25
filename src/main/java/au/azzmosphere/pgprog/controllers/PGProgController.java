package au.azzmosphere.pgprog.controllers;

import au.azzmosphere.pgprog.challengers.ChallengeFactory;
import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

/**
 * Created by aaron.spiteri on 15/5/17.
 */
@Controller
public class PGProgController {
    private ChallengeFactory challengeFactory;
    private ObjectMapper mapper = new ObjectMapper();
    private Logger logger = LoggerFactory.getLogger(PGProgController.class);

    public ChallengeFactory getChallengeFactory() {
        return challengeFactory;
    }

    @Autowired
    public void setChallengeFactory(ChallengeFactory challengeFactory) {
        this.challengeFactory = challengeFactory;
    }

    @RequestMapping(value = "/challenges/{id}", method = RequestMethod.POST)
    @ResponseBody public final HashMap process(@RequestParam(value = "data") String data, @PathVariable("id") String id) throws Exception {

        logger.debug("processing challenge with id " + id);
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() { };

        HashMap rv;
        try {
            HashMap input = mapper.readValue(data, typeRef);
            ChallengeInterface challenge = challengeFactory.challenge(id);
            challenge.reset();
            challenge.putInput(input);
            challenge.process();
            rv = challenge.returnValues();
        }
        catch (Exception e) {
            logger.error("while processing " + id + " :" + e.getMessage());
            throw e;
        }
        return rv;
    }
}
