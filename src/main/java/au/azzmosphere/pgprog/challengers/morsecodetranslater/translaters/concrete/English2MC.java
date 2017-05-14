package au.azzmosphere.pgprog.challengers.morsecodetranslater.translaters.concrete;

import au.azzmosphere.pgprog.challengers.morsecodetranslater.mappings.MCMapping;
import au.azzmosphere.pgprog.challengers.morsecodetranslater.translaters.TranslatorBase;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public class English2MC extends TranslatorBase<String> {

    @Override
    public String appender(MCMapping m) {
        return m.toMC();
    }

    @Override
    public String splitterString() {
        return MCMapping.SPACE.toAlpha() + "";
    }

    @Override
    public String wordSeparaterString() {
        return MCMapping.SPACE.toMC();
    }

    @Override
    protected String convert(String word) {
        StringBuilder sb = new StringBuilder();
        boolean firstLetter = true;

        for (char c : word.toCharArray()) {
            for (MCMapping m : MCMapping.values()) {
                if (m.isChar(c)) {
                    if (!firstLetter) {
                        sb.append(MCMapping.SPACE_BETWEEN_LETTERS.toMC());
                    }
                    else {
                        firstLetter = false;
                    }

                    sb.append(appender(m));
                }
            }
        }
        return sb.toString();
    }
}
