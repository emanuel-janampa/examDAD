package com.janampa.ms_lib_reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsLibReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLibReservasApplication.class, args);
	}

}
