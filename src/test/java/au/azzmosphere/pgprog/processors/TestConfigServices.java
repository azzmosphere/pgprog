package au.azzmosphere.pgprog.processors;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
/**
 * Created by aaron.spiteri on 21/5/17.
 */
public class TestConfigServices {

    private ConfigServices configServices;

    @Before
    public void createConfig() throws Exception {
         configServices = new ConfigServices();
    }

    @Test
    public void testConfigFile() {
        assertThat(configServices.getXmlConfigFile(), is("challenges.xml"));
    }
}
