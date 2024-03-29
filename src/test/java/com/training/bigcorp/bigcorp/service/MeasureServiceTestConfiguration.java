package com.training.bigcorp.bigcorp.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.training.bigcorp.bigcorp.service.measure","com.training.bigcorp.bigcorp.config.properties"})
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties
public class MeasureServiceTestConfiguration{}
