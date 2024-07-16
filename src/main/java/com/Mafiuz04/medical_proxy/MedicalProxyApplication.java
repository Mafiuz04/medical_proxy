package com.Mafiuz04.medical_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MedicalProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalProxyApplication.class, args);
	}

}
