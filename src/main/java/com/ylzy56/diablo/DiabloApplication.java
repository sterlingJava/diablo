package com.ylzy56.diablo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.ylzy56.diablo.dao")
@ServletComponentScan("com.ylzy56.diablo.filter")
public class DiabloApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DiabloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Thread.currentThread().join();
	}
}
