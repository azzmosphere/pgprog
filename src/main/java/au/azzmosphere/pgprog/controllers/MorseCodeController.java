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

public class MorseCodeController {
    private ChallengeInterface challengeInterface = new MorseCodeTranslater();

    @RequestMapping(value="/morsecode", method= RequestMethod.POST)
    public @ResponseBody MorseCodeModel translate(
            @RequestParam(value="texttotranslate") String textToTranslate,
            @RequestParam(value="language") String language
    ) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("texttotranslate", textToTranslate);
        hashMap.put("ttype", language);
        String rv = "";

        challengeInterface.putInput(hashMap);
        try {
            challengeInterface.process();
            HashMap h = challengeInterface.returnValues();
            rv = (String) h.get("texttranslated");
        }
        catch (Exception e) {
            rv = "ERROR: " + e.getMessage();
        }
        return new MorseCodeModel(rv);
    }
}
