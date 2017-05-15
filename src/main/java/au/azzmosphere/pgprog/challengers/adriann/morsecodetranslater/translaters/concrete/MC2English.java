package au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters.concrete;

import au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.mappings.MCMapping;
import au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters.TranslatorBase;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public class MC2English  extends TranslatorBase<Character> {

    @Override
    public Character appender(MCMapping m) {
        return m.toAlpha();
    }

    @Override
    public String splitterString() {
        return MCMapping.SPACE.toMC();
    }

    @Override
    public String wordSeparaterString() {
        return MCMapping.SPACE.toAlpha() + "";
    }

    @Override
    protected String convert(String word) {
        StringBuilder sb = new StringBuilder();

        for (String letter : word.split(MCMapping.SPACE_BETWEEN_LETTERS.toMC())) {
            for (MCMapping m : MCMapping.values()) {
                if (letter.equalsIgnoreCase(m.toMC())) {
                    sb.append(m.toAlpha());
                    break;
                }
            }
        }

        return sb.toString();
    }
}
