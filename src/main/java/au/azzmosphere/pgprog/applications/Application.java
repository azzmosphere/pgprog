package au.azzmosphere.pgprog.applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by aaron.spiteri on 13/5/17.
 */
@SpringBootApplication
@ComponentScan("au.azzmosphere.pgprog.controllers")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
