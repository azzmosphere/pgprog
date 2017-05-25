package au.azzmosphere.pgprog.controllers;

import au.azzmosphere.pgprog.models.config.ChallengeConfig;
import au.azzmosphere.pgprog.processors.ConfigServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by aaron.spiteri on 22/5/17.
 */
@Controller
public class PGViewController {
    private ConfigServices configServices;

    @Autowired
    public PGViewController(ConfigServices configServices) {
        this.configServices = configServices;
    }

    @RequestMapping(value = "/views/list", method = RequestMethod.GET)
    @ResponseBody public final List showList() {
        return configServices.listChallengeId();
    }

    @RequestMapping(value = "/views/challenge/{id}", method = RequestMethod.GET)
    @ResponseBody public final HashMap showChallenge(@PathVariable("id") String id) {
        HashMap<String, ChallengeConfig> rv = new HashMap<>();

        rv.put("challenge", configServices.findChallenge(id));

        return rv;
    }
}
