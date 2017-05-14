package au.azzmosphere.pgprog.controllers;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import au.azzmosphere.pgprog.challengers.MorseCodeTranslater;
import au.azzmosphere.pgprog.models.MorseCodeModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 *
 * The base controller is used to re-direct GET, PUT and other HTTP methods
 * to the more concrete controllers.
 *
 * Created by aaron.spiteri on 13/5/17.
 */
@Controller

public class MorseCodeController extends  ControllerBase {

    public MorseCodeController() {
        setChallenge(new MorseCodeTranslater());
    }

    @RequestMapping(value="/morsecode", method= RequestMethod.POST)
    public @ResponseBody HashMap translate(
            @RequestParam(value="texttotranslate") String textToTranslate,
            @RequestParam(value="ttype") String language
    ) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("texttotranslate", textToTranslate);
        hashMap.put("ttype", language);

        return process(hashMap);
    }
}
