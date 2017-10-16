package com.bin.mybatis.plus.model;

import com.bin.mybatis.plus.entity.Class;
import com.bin.mybatis.plus.entity.School;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author shaobin.qin
 */
@Getter
@Setter
public class SchCla extends School {

	private List<Class> classList;
}
