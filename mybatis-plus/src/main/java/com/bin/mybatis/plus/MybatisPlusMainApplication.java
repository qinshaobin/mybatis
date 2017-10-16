package com.bin.mybatis.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author shaobin.qin
 */
@SpringBootApplication
//开启自动扫描filters, servlets, and listeners
@ServletComponentScan
public class MybatisPlusMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusMainApplication.class, args);
	}
}
