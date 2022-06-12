package ru.fadeeva.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.fadeeva.profile.DevProfile;
import ru.fadeeva.profile.ProductionProfile;
import ru.fadeeva.profile.SystemProfile;

@Configuration
public class JavaConfig {

    @ConditionalOnProperty(prefix = "netology", name = "profile.dev", havingValue = "true")
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @ConditionalOnProperty(prefix = "netology", name = "profile.dev", havingValue = "false", matchIfMissing = true)
    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
