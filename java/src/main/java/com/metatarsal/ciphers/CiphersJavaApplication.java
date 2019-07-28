package com.metatarsal.ciphers;

import com.metatarsal.ciphers.controllers.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.metatarsal"})
public class CiphersJavaApplication implements CommandLineRunner {

	@Autowired
	BaseController baseController;

	public static void main(String[] args) {
		SpringApplication.run(CiphersJavaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		baseController.index();
	}
}
