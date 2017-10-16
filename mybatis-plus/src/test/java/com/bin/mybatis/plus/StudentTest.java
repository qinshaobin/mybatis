package com.bin.mybatis.plus;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.bin.mybatis.plus.entity.Student;
import com.bin.mybatis.plus.service.StudentService;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
public class StudentTest extends BaseTest {

	@Autowired
	private StudentService studentService;

	/**
	 * 所有字段插入
	 * <p>
	 *     INSERT INTO T_STUDENT ( name,age,BIRTHDAY,create_time,class_id )  VALUES
	 *     ('stu',null,to_timestamp('2017-09-17 20:57:07.496', 'yyyy-MM-dd hh24:mi:ss.ff3'),
	 *     to_timestamp('2017-09-17 20:57:07.496', 'yyyy-MM-dd hh24:mi:ss.ff3'),1 );
	 * </p>
	 */
	@Test
	public void testInsert() {

		Student student = Student.builder().name("stu").classId(1).birthDay(new Date()).createTime(new Date()).build();

		studentService.insert(student);
	}

	/**
	 * 字段选择插入
	 * <p>
	 *     INSERT INTO T_STUDENT ( name,BIRTHDAY,create_time,class_id )  VALUES
	 *     ('stu',to_timestamp('2017-09-17 20:59:12.840', 'yyyy-MM-dd hh24:mi:ss.ff3'),
	 *     to_timestamp('2017-09-17 20:59:12.840', 'yyyy-MM-dd hh24:mi:ss.ff3'),1 );
	 * </p>
	 */
	@Test
	public void testInsertSelective() {

		Student student = Student.builder().name("stu").classId(1).birthDay(new Date()).createTime(new Date()).build();

		studentService.insertSelective(student);
	}

	/**
	 * 根据主键查询记录
	 * <p>
	 *     SELECT id,name,age,BIRTHDAY AS birthDay,create_time AS createTime,class_id AS classId FROM T_STUDENT WHERE id=1;
	 * </p>
	 */
	@Test
	public void testGetStudentById() {

		Student student = studentService.getStudentById(1);
		if(student != null)
			System.err.println(JSON.toJSONString(student));
	}

	/**
	 * 查询所有记录
	 * <p>
	 *     SELECT id,name,age,BIRTHDAY AS birthDay,create_time AS createTime,class_id AS classId  FROM T_STUDENT;
	 * </p>
	 */
	@Test
	public void testGetAllStudents() {

		List<Student> students = studentService.getAllStudents();
		students.forEach(student -> System.err.println(JSON.toJSONString(student)));
	}

	/**
	 * 字段选择查询
	 * <p>
	 *     SELECT id,name,age,BIRTHDAY AS birthDay,create_time AS createTime,class_id AS classId  FROM T_STUDENT
	 *     WHERE  name='stu1' AND class_id=1;
	 * </p>
	 */
	@Test
	public void testGetStudentsByCon() {

		Student student = Student.builder().name("stu1").id(null).classId(1).build();

		List<Student> students = studentService.getStudentsByCon(student);
		students.forEach(stu -> System.err.println(JSON.toJSONString(stu)));
	}

	/**
	 * 字段选择查询:序列化时属性名一定要和数据库字段名相同，属性为空的不参与条件比较
	 * eg:FastJson可以使用@JSONField(name='???')处理
	 * <p>
	 *     SELECT id,name,age,BIRTHDAY AS birthDay,create_time AS createTime,class_id AS classId  FROM T_STUDENT
	 *     WHERE (name = 'stu1' AND CLASS_ID = 1);
	 * </p>
	 */
	@Test
	public void testGetStudentsByCon2Map() {

		Student student = Student.builder().name("stu1").id(null).classId(1).build();

		List<Student> students = studentService.getStudentsByCon2Map(student);
		students.forEach(stu -> System.err.println(JSON.toJSONString(stu)));
	}

	/**
	 * 字段选择查询:key必须跟数据库字段一致，key为null不参与条件比较
	 * <p>
	 *     SELECT id,name,age,BIRTHDAY AS birthDay,create_time AS createTime,class_id AS classId  FROM T_STUDENT
	 *     WHERE (class_id = 1 AND name = 'stu1');
	 * </p>
	 */
	@Test
	public void testGetStudentsByMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("id", null);
		map.put("name", "stu1");
		map.put("class_id", 1);

		List<Student> students = studentService.getStudentsByMap(map);
		students.forEach(stu -> System.err.println(JSON.toJSONString(stu)));
	}

	/**
	 * 根据条件查询记录数
	 * <p>
	 *     SELECT COUNT(1) FROM T_STUDENT WHERE class_id=1;
	 * </p>
	 */
	@Test
	public void testGetStudentCountByCon() {

		Student student = Student.builder().classId(1).build();

		System.err.println("符合条件的记录数：" + studentService.getStudentCountByCon(student));
	}

	/**
	 * 分页查询,可指定排序字段
	 */
	@Test
	public void testGetStudentsByPage() {

		Page<Student> page = new Page<>(1, 2);
		//page.setOrderByField("age");
		//page.setAsc(false);

		Student student = Student.builder().classId(2).build();

		Page<Student> students = studentService.getStudentsByPage(page, student);
		System.out.println(JSON.toJSONString(students));
		System.err.println("总记录数:" + students.getTotal());
		for(Student stu : students.getRecords())
			System.out.println(JSON.toJSONString(stu));
	}

	/**
	 * 字段选择更新
	 * <p>
	 *     UPDATE T_STUDENT  SET age=25  WHERE id=10;
	 * </p>
	 */
	@Test
	public void testUpdateById() {

		Student student = Student.builder().id(10).age(25).build();

		studentService.updateById(student);
	}

	/**
	 * 所有字段更新
	 * <P>
	 *     UPDATE T_STUDENT  SET name=null,age=25,BIRTHDAY=null,create_time=null,class_id=null  WHERE id=10;
	 * </P>
	 */
	@Test
	public void testUpdateAllColumnById() {

		Student student = Student.builder().id(10).age(25).build();

		studentService.updateAllColumnById(student);
	}

	/**
	 * 根据主键删除
	 * <p>
	 *     DELETE FROM T_STUDENT WHERE id=10;
	 * </p>
	 */
	@Test
	public void testDeleteById() {
		Student student = Student.builder().id(10).build();

		studentService.deleteById(student);
		studentService.deleteById(10);
	}
}
