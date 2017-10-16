package com.bin.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author shaobin.qin
 */
@Data
public class Student {

	private Integer id;

	private String name;

	private Integer age;

	private Date birthDay;

	private Date createTime;
}
