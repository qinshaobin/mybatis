package com.bin.mybatis.plus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.bin.mybatis.plus.entity.Class;

import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
public interface ClassService {

	/**
	 * 新增班级记录(所有字段)
	 */
	int insert(Class aClass);

	/**
	 * 新增班级记录(部分字段)
	 */
	int insertSelective(Class aClass);

	/**
	 * 根据主键查询班级
	 */
	Class getClassById(Integer id);

	/**
	 * 查询所有班级列表
	 */
	List<Class> getAllClasses();

	/**
	 * 根据条件查询班级列表
	 */
	List<Class> getClassesByCon(Class aClass);

	/**
	 * 根据条件查询班级列表
	 */
	List<Class> getClassesByCon2Map(Class aClass);

	/**
	 * 根据条件查询班级列表
	 */
	List<Class> getClassesByMap(Map<String, Object> map);

	/**
	 * 根据条件查询班级列表
	 */
	List<Class> getClassesByMap2(Map<String, Object> map);

	/**
	 * 根据条件查询记录数
	 */
	Integer getClassCountByCon(Class aClass);

	/**
	 * 根据条件分页查询班级记录
	 */
	Page<Class> getClassesByPage(Page<Class> page, Class aClass);

	/**
	 * 根据主键更新班级记录(字段选择更新)
	 */
	boolean updateById(Class aClass);

	/**
	 * 根据主键更新班级记录(所有字段更新)
	 */
	boolean updateAllColumnById(Class aClass);

	/**
	 * 根据主键删除记录
	 */
	boolean deleteById(Integer id);

	/**
	 * 根据主键批量删除记录
	 */
	boolean deleteBatchIds(List<Integer> ids);

	/**
	 * 根据条件，删除记录
	 */
	boolean delete(Class aClass);
}
