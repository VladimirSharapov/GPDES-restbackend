package com.vladsh.main.web.config;

import com.vladsh.main.integration.config.AppModulesConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Vladimir Sharapov
 */
@Configuration
@Import({AppModulesConfig.class})
public class AppConfig {
}
