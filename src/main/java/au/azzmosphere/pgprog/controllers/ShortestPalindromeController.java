package au.azzmosphere.pgprog.controllers;

import au.azzmosphere.pgprog.challengers.ideserve.ShortestPalindrome;
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
public class ShortestPalindromeController extends ControllerBase  {
    public ShortestPalindromeController() {
        setChallenge(new ShortestPalindrome());
    }

    @RequestMapping(value="/shortestpalindromectl", method= RequestMethod.POST)
    public @ResponseBody HashMap process(@RequestParam(value="inputString") String inputString) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("inputString", inputString);

        return super.process(hashMap);
    }
}
