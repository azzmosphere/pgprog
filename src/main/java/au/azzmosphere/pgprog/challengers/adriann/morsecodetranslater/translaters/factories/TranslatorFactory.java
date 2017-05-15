package au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters.factories;
import au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters.concrete.MC2English;
import au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters.concrete.English2MC;
import au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters.Translator;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public class TranslatorFactory {
    public enum translatorTypes {
        ENGLISH2MC,
        MCTOENGLISH
    }

    public Translator findTranslator(translatorTypes t) throws NoTranslatorException {
        switch (t) {
            case ENGLISH2MC:
                return new English2MC();
            case MCTOENGLISH:
                return new MC2English();
            default:
                throw new NoTranslatorException();
        }
    }
}
