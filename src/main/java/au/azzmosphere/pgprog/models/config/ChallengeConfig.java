package au.azzmosphere.pgprog.models.config;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aaron.spiteri on 21/5/17.
 */
public class ChallengeConfig {
    private String id;      // ID
    private String heading; // Heading used in view
    private String description; // Description used in view
    private String clazz;       // challenger class to use.

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    @XmlElement
    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public String getClazz() {
        return clazz;
    }

    @XmlElement
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
