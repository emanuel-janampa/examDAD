package com.janampa.ms_lib_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsLibConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsLibConfigApplication.class, args);
    }
}