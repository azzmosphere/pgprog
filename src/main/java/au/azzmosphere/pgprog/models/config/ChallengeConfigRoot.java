package au.azzmosphere.pgprog.models.config;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by aaron.spiteri on 21/5/17.
 */

@XmlRootElement(name="challenges")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChallengeConfigRoot {
    private List<ChallengeConfig> challenge;

    public List<ChallengeConfig> getChalenge() {
        return challenge;
    }

    @XmlElement(name="challenge")
    public void setChalenge(List<ChallengeConfig> challenge) {
        this.challenge = challenge;
    }
}

