package com.vladsh.main.integration.config;

import com.vladsh.bl.module.config.BlModuleRestConfig;
import com.vladsh.bl.module.server.MyTestRestServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Vladimir Sharapov
 */
@Configuration
@Import({BlModuleRestConfig.class})
public class AppRestConfig {


}
