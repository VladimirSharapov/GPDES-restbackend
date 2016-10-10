package com.vladsh.bl.module.config;

import com.vladsh.bl.module.server.MyService;
import com.vladsh.bl.module.server.MyTestRestServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Vladimir Sharapov
 */
@Configuration
@EnableWebMvc
public class BlModuleRestConfig {

    @Autowired
    private MyService myService;

    @Bean
    public MyTestRestServer myrestTestServer() {
        return new MyTestRestServer(myService);
    }
}
