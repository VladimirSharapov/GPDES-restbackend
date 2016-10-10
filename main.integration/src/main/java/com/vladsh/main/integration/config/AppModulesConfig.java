package com.vladsh.main.integration.config;

import com.vladsh.bl.module.config.BlModuleConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Vladimir Sharapov
 */
@Configuration
@Import({BlModuleConfig.class})
public class AppModulesConfig {
}
