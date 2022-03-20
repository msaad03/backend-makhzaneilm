package io.magazine.makhzaneilm;

import io.magazine.makhzaneilm.service.FileStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class MakhzaneilmApplication {

	@Resource
	FileStorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(MakhzaneilmApplication.class, args);
	}
	
}
