package au.azzmosphere.pgprog.challengers.morsecodetranslater.translaters;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public interface Translator {
    String translate(String s) throws UnknownConversionException;
}
