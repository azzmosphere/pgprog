package au.azzmosphere.pgprog.models;

/**
 * Created by aaron.spiteri on 13/5/17.
 */
public class MorseCodeModel {
    private String translatedText;

    public MorseCodeModel(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
