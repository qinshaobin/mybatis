package com.bin.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author shaobin.qin
 */
@SpringBootApplication
//开启自动扫描filters, servlets, and listeners
@ServletComponentScan
public class MybatisBaseMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisBaseMainApplication.class, args);
	}
}
