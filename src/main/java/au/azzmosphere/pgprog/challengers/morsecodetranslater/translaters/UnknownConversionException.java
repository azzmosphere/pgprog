package au.azzmosphere.pgprog.challengers.morsecodetranslater.translaters;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public class UnknownConversionException extends Exception{
    public UnknownConversionException(String word) {
        super("unable to find a converstion for word " + word);
    }
}
