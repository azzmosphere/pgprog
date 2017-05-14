package au.azzmosphere.pgprog.challengers;

import java.util.HashMap;
import au.azzmosphere.pgprog.challengers.morsecodetranslater.translaters.Translator;
import au.azzmosphere.pgprog.challengers.morsecodetranslater.translaters.factories.TranslatorFactory;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public class MorseCodeTranslater implements ChallengeInterface {
    private String textin = null;
    private HashMap<String, String> output = new HashMap<>();
    private TranslatorFactory tfactory = new TranslatorFactory();
    private Exception lastError;
    private TranslatorFactory.translatorTypes ttype = null;

    @Override
    public void putInput(HashMap inputMap) {
        textin = (String) inputMap.get("texttotranslate");
        for (TranslatorFactory.translatorTypes ttype : TranslatorFactory.translatorTypes.values()) {
            if ( ((String) inputMap.get("ttype")).equals(ttype.name())) {
                this.ttype = ttype;
            }
        }
    }

    @Override
    public void process() throws Exception {
        Translator translator = tfactory.findTranslator(ttype);
        output.put("texttranslated", translator.translate(textin));
    }

    @Override
    public HashMap returnValues() {
        return output;
    }
}
