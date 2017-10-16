package com.bin.mybatis.plus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.bin.mybatis.plus.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
public interface StudentService {

	/**
	 * 新增学生记录(所有字段)
	 */
	boolean insert(Student student);

	/**
	 * 新增学生记录(部分字段)
	 */
	boolean insertSelective(Student student);

	/**
	 * 根据主键查询学生
	 */
	Student getStudentById(Integer id);

	/**
	 * 查询所有学生列表
	 */
	List<Student> getAllStudents();

	/**
	 * 根据条件查询学生列表
	 */
	List<Student> getStudentsByCon(Student student);

	/**
	 * 根据条件查询学生列表
	 */
	List<Student> getStudentsByCon2Map(Student student);

	/**
	 * 根据条件查询学生列表
	 */
	List<Student> getStudentsByMap(Map<String, Object> map);

	/**
	 * 根据条件查询记录数
	 */
	Integer getStudentCountByCon(Student student);

	/**
	 * 根据条件分页查询学生记录
	 */
	Page<Student> getStudentsByPage(Page<Student> page, Student student);

	/**
	 * 根据主键更新学生记录(字段选择更新)
	 */
	boolean updateById(Student student);

	/**
	 * 根据主键更新学生记录(所有字段更新)
	 */
	boolean updateAllColumnById(Student student);

	/**
	 * 根据主键删除记录
	 */
	boolean deleteById(Student student);

	/**
	 * 根据主键删除记录
	 */
	boolean deleteById(Integer id);
}
