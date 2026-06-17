package com.janampa.ms_lib_prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsLibPrestamosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLibPrestamosApplication.class, args);
	}

}
