package au.azzmosphere.pgprog.controllers.ideserve;

import au.azzmosphere.pgprog.challengers.ideserve.OddNumberChallenge;
import au.azzmosphere.pgprog.controllers.ControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by aaron.spiteri on 15/5/17.
 */
@Controller
public class OddNumberChallengeController extends ControllerBase {
    public OddNumberChallengeController() {
        setChallenge(new OddNumberChallenge());
    }

    @RequestMapping(value="/oddnumberchallenge", method= RequestMethod.POST)
    public @ResponseBody HashMap process(@RequestParam(value="numberarray") String numberarray) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("numberarray", numberarray);
        return process(hashMap);
    }
}
