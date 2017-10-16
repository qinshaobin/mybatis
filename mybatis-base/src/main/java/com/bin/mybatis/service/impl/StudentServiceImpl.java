package com.bin.mybatis.service.impl;

import com.bin.mybatis.entity.Student;
import com.bin.mybatis.mapper.StudentMapper;
import com.bin.mybatis.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public List<Student> getAllStudents() {
		return studentMapper.selectList();
	}

	@Override
	public List<Student> getStudentsByCon(Student student) {
		return studentMapper.selectListByCon(student);
	}

	@Override
	public List<Student> getStudentsByMap(Map<String, Object> map) {
		return studentMapper.selectListByCon(map);
	}
}
