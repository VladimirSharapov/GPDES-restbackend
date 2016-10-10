package com.vladsh.bl.module.config;

import com.vladsh.bl.module.server.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vladimir Sharapov
 */
@Configuration
public class BlModuleConfig {


    @Bean
    public MyService myService() {
        return new MyService();
    }

}
