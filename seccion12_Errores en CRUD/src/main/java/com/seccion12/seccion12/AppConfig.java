package com.seccion12.seccion12;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.PropertySource;

@Configurable
@PropertySource("classpath:messages.properties")
public class AppConfig {
    
}
