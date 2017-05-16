package au.azzmosphere.pgprog.controllers.ideserve;

import au.azzmosphere.pgprog.challengers.ideserve.MissingNumInDupArrays;
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
public class MissingNumInDupArraysCtl extends ControllerBase {
    public MissingNumInDupArraysCtl() {
        setChallenge(new MissingNumInDupArrays());
    }

    @RequestMapping(value="/missingnumindupreq2", method= RequestMethod.POST )
    public @ResponseBody HashMap process(
            @RequestParam(value="a1") String a1,
            @RequestParam(value="a2") String a2) {
        HashMap<String, String> input = new HashMap<>();
        input.put("a1", a1);
        input.put("a2", a2);
        return super.process(input);
    }
}
