package au.azzmosphere.pgprog.challengers.adriann.morsecodetranslater.mappings;

/**
 * Created by aaron.spiteri on 14/5/17.
 */
public interface MCMappingIface {
    char toAlpha();
    String toMC();
    boolean isChar(char c);
    boolean isMC(String mc);
}
