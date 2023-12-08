package com.sgtpied.sgt;

import com.sgtpied.sgt.admin.models.SpringSecurityAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@EnableJpaAuditing(auditorAwareRef="auditorAware")
@EnableWebSocketMessageBroker
@SpringBootApplication
public class sgtApplication extends AbstractWebSocketMessageBrokerConfigurer {


    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }

    public static void main(String[] args) {
        SpringApplication.run(sgtApplication.class, args);
    }

}
