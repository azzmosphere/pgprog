package au.azzmosphere.pgprog.challengers;

import au.azzmosphere.pgprog.models.config.ChallengeConfig;
import au.azzmosphere.pgprog.processors.ConfigServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Given a Challenge ID the object will return the challenge concrete class.
 *
 * Created by aaron.spiteri on 17/5/17.
 */
@Service
public class ChallengeFactory {
    private ConfigServices configServices;
    private Logger logger = LoggerFactory.getLogger(ChallengeFactory.class);

    @Autowired
    public ChallengeFactory(ConfigServices configServices) {
        this.configServices = configServices;
    }

    public ChallengeInterface challenge(String id) throws Exception {
        ChallengeConfig challengeConfig = configServices.findChallenge(id);
        ClassLoader classLoader = ChallengeFactory.class.getClassLoader();
        String clazz = challengeConfig.getClazz();

        logger.debug("attempting to load class " + clazz);
        Class thisChallenge =  classLoader.loadClass(clazz);

        return (ChallengeInterface) thisChallenge.newInstance();
    }
}
