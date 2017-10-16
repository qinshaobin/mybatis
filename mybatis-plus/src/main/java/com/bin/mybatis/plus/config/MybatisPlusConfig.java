package com.bin.mybatis.plus.config;

import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shaobin.qin
 */
@Configuration
@MapperScan(basePackages = "com.bin.mybatis.plus.mapper", annotationClass = Mapper.class)
@EnableTransactionManagement
public class MybatisPlusConfig {

	/**
	 * SQL执行效率插件
	 */
//	@Bean
//	@Profile("dev")
	public PerformanceInterceptor performanceInterceptor() {
		return new PerformanceInterceptor();
	}

	/**
	 * 乐观锁插件
	 * 乐观锁实现方式：
	 * 取出记录时，获取当前version
	 * 更新时，带上这个version
	 * 执行更新时， set version = yourVersion+1 where version = yourVersion
	 * 如果version不对，就更新失败
	 */
	@Bean
	public OptimisticLockerInterceptor OptimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}

	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//		paginationInterceptor.setLocalPage(true); //开启 PageHelper 的支持
		paginationInterceptor.setDialectType(DBType.MYSQL.getDb());

		return paginationInterceptor;
	}
}
