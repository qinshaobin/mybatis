package com.bin.mybatis;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author shaobin.qin
 * 需要需要打war包，则必须继承SpringBootServletInitializer类，然后
 * 覆盖其configure方法
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MybatisBaseMainApplication.class);
	}

}
