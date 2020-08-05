package com.daiso.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@ServletComponentScan
@SpringBootApplication
@ComponentScan(basePackages = "com.daiso")
@MapperScan(basePackages = "com.mapper.mapper")
public class DaisoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaisoApplication.class, args);
	}

}

