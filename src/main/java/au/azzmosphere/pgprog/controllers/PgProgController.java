package au.azzmosphere.pgprog.controllers;

import au.azzmosphere.pgprog.models.MorseCodeModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by aaron.spiteri on 13/5/17.
 */
@Controller

public class PgProgController {

    @RequestMapping("/morsecode")
    public @ResponseBody MorseCodeModel translate() {
        return new MorseCodeModel("hello world");
    }
}
