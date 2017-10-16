package com.bin.mybatis.plus.service;

import com.baomidou.mybatisplus.service.IService;
import com.bin.mybatis.plus.entity.School;
import com.bin.mybatis.plus.model.SchCla;


/**
 * @author shaobin.qin
 */
public interface SchoolService extends IService<School> {

	/**
	 * 查询一个学校下所有的班级
	 */
	SchCla getSchClasById(int id);
}
