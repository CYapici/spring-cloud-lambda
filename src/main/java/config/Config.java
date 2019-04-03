package config;

import generator.IdGenerator;
import org.springframework.cloud.function.context.FunctionScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@FunctionScan
@Configuration
public class Config {
    @Bean
    public IdGenerator idGenerator() {
        return new IdGenerator();
    }
}
