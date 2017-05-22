package au.azzmosphere.pgprog.processors;

import javax.xml.bind.JAXBContext;

import au.azzmosphere.pgprog.models.config.ChallengeConfig;
import au.azzmosphere.pgprog.models.config.ChallengeConfigRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

/**
 * Created by aaron.spiteri on 21/5/17.
 */
@Component
public class ConfigServices {
    private Environment environment;

    private String xmlConfigFile;
    private String xmlSchema;
    private Logger logger = LoggerFactory.getLogger(ConfigServices.class);
    private ChallengeConfigRoot challenges;

    /**
     * list all challenges.
     *
     * @return
     */
    public ChallengeConfigRoot listChalenges() {
        return challenges;
    }

    /**
     * return challenge that has the ID of id or return null.
     *
     * @param id
     * @return
     */
    public ChallengeConfig findChallenge(String id) {
        for (ChallengeConfig challenge : listChalenges().getChalenge()) {
            if (challenge.getId().equals(id)) {
                return challenge;
            }
        }
        return null;
    }

    @Autowired
    public ConfigServices(Environment environment) throws Exception {
        this.environment = environment;

        xmlConfigFile = environment.getProperty("challenges.config");
        logger.debug("setting the XML config path to " + xmlConfigFile);

        xmlSchema = environment.getProperty("challenges.schema");
        logger.debug("setting the XML schema to " + xmlSchema);

        try {
            readXMLProperties();
        }
        catch(Exception e) {
            logger.error("unable to retrieve configuration.  Got error " + e.getMessage() + ": " + e.toString());
            throw e;
        }

        logger.debug("configuration has been retrieved");
    }

    private void readXMLProperties() throws Exception {
        logger.debug("config services started");
        SchemaFactory factory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xmlSchema));

        JAXBContext jc = JAXBContext.newInstance(ChallengeConfigRoot.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        File xml = new File(xmlConfigFile);
        challenges = (ChallengeConfigRoot) unmarshaller.unmarshal(xml);
    }


}
