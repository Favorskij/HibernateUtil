package com.hibernateutil.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.hibernateutil.controller", "com.hibernateutil.repository"})
public class Config {

}