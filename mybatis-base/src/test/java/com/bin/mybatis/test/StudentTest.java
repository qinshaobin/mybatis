package com.bin.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.bin.mybatis.entity.Student;
import com.bin.mybatis.service.StudentService;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
public class StudentTest extends AbstractSpringContextTestSupport {

	@Autowired
	private StudentService studentService;

	@Test
	public void testGetAllStudents() {

		List<Student> students = studentService.getAllStudents();
		if(CollectionUtils.isNotEmpty(students))
			System.err.println(JSON.toJSONString(students));
	}

	@Test
	public void testGetStudentsByCon() {

		Student student = new Student();
		student.setAge(25);

		// 属性为空会参与条件比较，
		// SELECT  id,name,age,BIRTHDAY AS birthDay,create_time AS createTime  FROM student WHERE  (id = 0 AND name = null AND age = 25);
		List<Student> students = studentService.getStudentsByCon(student);
		if(CollectionUtils.isNotEmpty(students))
			System.err.println(JSON.toJSONString(students));
	}

	@Test
	public void testGetStudentsByMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("id", null);
		map.put("name", "bin");

		// ；value为空不会参与条件比较，
		// SELECT id,name,age,BIRTHDAY AS birthDay,create_time AS createTime FROM user WHERE name = 'bin';
		List<Student> students = studentService.getStudentsByMap(map);
		if(CollectionUtils.isNotEmpty(students))
			System.err.println(JSON.toJSONString(students));
	}
}
