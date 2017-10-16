package com.bin.mybatis.service;

import com.bin.mybatis.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
public interface StudentService {

	/**
	 * 查询所有用户列表
	 */
	List<Student> getAllStudents();

	/**
	 * 根据条件查询用户列表
	 */
	List<Student> getStudentsByCon(Student student);

	/**
	 * 根据条件查询用户列表
	 */
	List<Student> getStudentsByMap(Map<String, Object> map);
}
