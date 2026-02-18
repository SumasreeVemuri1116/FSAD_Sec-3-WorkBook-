package com.klu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:student-beans.xml")
public class XmlImportConfig {
}
