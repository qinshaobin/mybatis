package com.bin.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bin.mybatis.plus.service.StudentService;
import com.bin.mybatis.plus.util.EntityWrapperUtil;
import com.bin.mybatis.plus.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Override
	public boolean insert(Student student) {
		return student.insertAllColumn();
	}

	@Override
	public boolean insertSelective(Student student) {
		return student.insert();
	}

	@Override
	public Student getStudentById(Integer id) {
		return new Student().selectById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return new Student().selectAll();
	}

	@Override
	public List<Student> getStudentsByCon(Student student) {
		return student.selectList(new EntityWrapper<>(student));
	}

	@Override
	public List<Student> getStudentsByCon2Map(Student student) {
		return student.selectList(EntityWrapperUtil.getEqMapEntityWrapper(student));
	}

	@Override
	public List<Student> getStudentsByMap(Map<String, Object> map) {
		return new Student().selectList(EntityWrapperUtil.getEqMapEntityWrapper(map));
	}

	@Override
	public Integer getStudentCountByCon(Student student) {
		return student.selectCount(new EntityWrapper<>(student));
	}

	@Override
	public Page<Student> getStudentsByPage(Page<Student> page, Student student) {
		return student.selectPage(page, new EntityWrapper<>(student));
	}

	@Override
	public boolean updateById(Student student) {
		return student.updateById();
	}

	@Override
	public boolean updateAllColumnById(Student student) {
		return student.updateAllColumnById();
	}

	@Override
	public boolean deleteById(Student student) {
		return student.deleteById();
	}

	@Override
	public boolean deleteById(Integer id) {
		return new Student().deleteById(id);
	}
}
