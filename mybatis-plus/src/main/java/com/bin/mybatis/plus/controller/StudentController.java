package com.bin.mybatis.plus.controller;

import com.alibaba.fastjson.JSON;
import com.bin.mybatis.plus.entity.Student;
import com.bin.mybatis.plus.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shaobin.qin
 */
@RequestMapping("/stu/")
@RestController
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		log.info("查询全部学生列表：{}", JSON.toJSONString(students));
		return students;
	}

}
