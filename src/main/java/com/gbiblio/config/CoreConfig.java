package com.gbiblio.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "file:src/main/resources/properties/spring/applicationContext.xml" })
public class CoreConfig {


}