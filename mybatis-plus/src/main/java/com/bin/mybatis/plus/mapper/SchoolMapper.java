package com.bin.mybatis.plus.mapper;

import com.bin.mybatis.plus.entity.School;
import com.bin.mybatis.plus.model.SchCla;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shaobin.qin
 */
@Mapper
public interface SchoolMapper extends BaseMapper<School> {

	/**
	 * 查询一个学校下所有的班级，以及班级中的学生
	 */
	SchCla getSchClasById(int id);
}
