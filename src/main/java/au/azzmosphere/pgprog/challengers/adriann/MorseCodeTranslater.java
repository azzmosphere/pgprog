package au.azzmosphere.pgprog.challengers.adriann;

import java.util.HashMap;

import au.azzmosphere.pgprog.challengers.ChallengeInterface;
import au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters.Translator;
import au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters.factories.TranslatorFactory;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public class MorseCodeTranslater implements ChallengeInterface {
    private String textin;
    private HashMap<String, String> output = new HashMap<>();
    private TranslatorFactory tfactory = new TranslatorFactory();
    private TranslatorFactory.translatorTypes ttype;

    @Override
    public void putInput(HashMap inputMap) {
        textin = (String) inputMap.get("inputString");
        for (TranslatorFactory.translatorTypes ttype : TranslatorFactory.translatorTypes.values()) {
            if ((inputMap.get("ttype")).equals(ttype.name())) {
                this.ttype = ttype;
            }
        }
    }

    @Override
    public void process() throws Exception {
        Translator translator = tfactory.findTranslator(ttype);
        output.put("outputString", translator.translate(textin));
    }

    @Override
    public HashMap returnValues() {
        return output;
    }

    @Override
    public void reset() {
        textin = null;
        output = new HashMap<>();
        ttype = null;
    }
}
