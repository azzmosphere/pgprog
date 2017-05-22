package au.azzmosphere.pgprog.models.config;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aaron.spiteri on 21/5/17.
 */
public class ChallengeConfig {
    private String id;      // ID
    private String heading; // Heading used in view
    private String title;   // title used in view
    private String endPoint;    // web interception end point.
    private String description; // Description used in view
    private String view;        // view to use
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

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndPoint() {
        return endPoint;
    }

    @XmlElement
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public String getView() {
        return view;
    }

    @XmlElement
    public void setView(String view) {
        this.view = view;
    }

    public String getClazz() {
        return clazz;
    }

    @XmlElement
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
