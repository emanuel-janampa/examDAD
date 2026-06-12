package com.janampa.ms_lib_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer; // <-- ASEGÚRATE DE QUE ESTA LÍNEA ESTÉ ESCRITA

@SpringBootApplication
@EnableEurekaServer
public class MsLibEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsLibEurekaApplication.class, args);
    }
}