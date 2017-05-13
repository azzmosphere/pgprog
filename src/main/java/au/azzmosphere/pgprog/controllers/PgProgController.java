package au.azzmosphere.pgprog.controllers;

import au.azzmosphere.pgprog.models.MorseCodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.ApplicationContext;

/**
 * Created by aaron.spiteri on 13/5/17.
 */
@Controller

public class PgProgController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/morsecode")
    public @ResponseBody MorseCodeModel translate() {
        return new MorseCodeModel("hello world");
    }
}
