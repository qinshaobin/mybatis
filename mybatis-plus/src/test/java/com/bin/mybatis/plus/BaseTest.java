package com.bin.mybatis.plus;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest {

	protected static final String DATEFORMAT1 = "yyyy-mm-dd";

	protected static final String DATEFORMAT2 = "yyyy-MM-dd HH:mm:ss";

}
