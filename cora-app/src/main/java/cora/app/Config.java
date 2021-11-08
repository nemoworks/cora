package cora.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CoraRuntimeWiring coraRuntimeWiring(){
        return new CoraRuntimeWiring();
    }
    
}
