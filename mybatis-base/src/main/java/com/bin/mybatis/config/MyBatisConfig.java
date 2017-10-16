package com.bin.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.bin.mybatis.mapper")
@EnableTransactionManagement
public class MyBatisConfig {

}
