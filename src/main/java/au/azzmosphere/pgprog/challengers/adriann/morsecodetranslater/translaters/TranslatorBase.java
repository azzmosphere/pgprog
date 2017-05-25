package au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.translaters;

import java.util.Arrays;
import au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.mappings.MCMapping;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public abstract class TranslatorBase<T> implements Translator {
    @Override
    public String translate(String s) throws UnknownConversionException {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(splitterString());
        int size = (Arrays.asList(words)).size(), i = 0;

        for (String word : words) {
            i++;
            String convertedWord = convert(word);

            // throw a exception if the word can not be converted.
            if (convertedWord.length() == 0) {
                throw new UnknownConversionException(word);
            }
            sb.append(convertedWord);

            if (i != size) {
                sb.append(wordSeparaterString());
            }
        }

        return sb.toString();
    }



    public abstract T appender(MCMapping m);

    /**
     *
     * @return string used to split each word
     */
    public abstract String splitterString();

    /**
     *
     * @return string used when combining the words
     */
    public abstract String wordSeparaterString();

    /**
     * convert each word into the corresponding text
     *
     * @param word
     * @return
     */
    protected abstract String convert(String word);
}
