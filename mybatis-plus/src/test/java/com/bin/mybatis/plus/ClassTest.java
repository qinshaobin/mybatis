package com.bin.mybatis.plus;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.bin.mybatis.plus.entity.Class;
import com.bin.mybatis.plus.service.ClassService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
public class ClassTest extends BaseTest {

	@Autowired
	private ClassService classService;

	/**
	 * 所有字段插入
	 * <p>
	 *     INSERT INTO T_CLASS(name,school_id) VALUES ('cla3',null);
	 * </p>
	 */
	@Test
	public void testInsert() {

		Class aClass = Class.builder().name("cla3").build();

		classService.insert(aClass);
	}

	/**
	 * 字段选择插入
	 * <p>
	 *     INSERT INTO T_CLASS(name) VALUES ('cla3');
	 * </p>
	 */
	@Test
	public void testInsertSelective() {

		Class aClass = Class.builder().name("cla3").build();

		classService.insertSelective(aClass);
	}

	/**
	 * 根据主键查询记录
	 * <p>
	 *     SELECT id AS id,name,school_id AS schoolId FROM T_CLASS WHERE id=1;
	 * </p>
	 */
	@Test
	public void testGetClassById() {

		Class aClass = classService.getClassById(1);
		if(aClass != null)
			System.err.println(JSON.toJSONString(aClass));
	}

	/**
	 * 查询所有记录
	 * <p>
	 *     SELECT  id AS id,name,school_id AS schoolId  FROM T_CLASS;
	 * </p>
	 */
	@Test
	public void testGetAllClasss() {

		List<Class> aClasss = classService.getAllClasses();
		aClasss.forEach(aClass -> System.err.println(JSON.toJSONString(aClass)));
	}

	/**
	 * 字段选择查询
	 * <p>
	 *     SELECT  id AS id,name,school_id AS schoolId  FROM T_CLASS
	 *     WHERE  school_id=1;
	 * </p>
	 */
	@Test
	public void testGetClasssByCon() {

		Class aClass = Class.builder().schoolId(1).build();

		List<Class> aClasses = classService.getClassesByCon(aClass);
		aClasses.forEach(stu -> System.err.println(JSON.toJSONString(stu)));
	}

	/**
	 * 字段选择查询：序列化时属性名一定要和数据库字段名相同，属性为空的不参与条件比较
	 * eg:FastJson可以使用@JSONField(name='???')处理
	 * <p>
	 *     SELECT  id AS id,name,school_id AS schoolId  FROM T_CLASS
	 *     WHERE  (SCHOOL_ID = 1);
	 * </p>
	 */
	@Test
	public void testGetClasssByCon2Map() {

		Class aClass = Class.builder().schoolId(1).build();

		List<Class> aClasses = classService.getClassesByCon2Map(aClass);
		aClasses.forEach(stu -> System.err.println(JSON.toJSONString(stu)));
	}

	/**
	 * 字段选择查询：key必须跟数据库字段一致，key为null不参与条件比较
	 * <p>
	 *     SELECT  id AS id,name,school_id AS schoolId  FROM T_CLASS
	 *     WHERE  (SCHOOL_ID = 1);
	 * </p>
	 */
	@Test
	public void testGetClasssByMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("SCHOOL_ID", 1);
		map.put("ID", null);

		List<Class> aClasses = classService.getClassesByMap(map);
		aClasses.forEach(stu -> System.err.println(JSON.toJSONString(stu)));
	}

	/**
	 * 字段选择查询：key必须跟数据库字段一致，key为null不参与条件比较
	 * <p>
	 *     SELECT  id AS id,name,school_id AS schoolId  FROM T_CLASS
	 *     WHERE  (SCHOOL_ID = 1);
	 * </p>
	 */
	@Test
	public void testGetClasssByMap2() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("SCHOOL_ID", 1);
		map.put("ID", null);

		List<Class> aClasses = classService.getClassesByMap2(map);
		aClasses.forEach(stu -> System.err.println(JSON.toJSONString(stu)));
	}

	/**
	 * 根据条件查询记录数
	 * <p>
	 *     SELECT COUNT(1) FROM T_CLASS WHERE  school_id=1;
	 * </p>
	 */
	@Test
	public void testGetClassCountByCon() {

		Class aClass = Class.builder().schoolId(1).build();

		System.err.println("符合条件的记录数：" + classService.getClassCountByCon(aClass));
	}

	@Test
	public void testGetClassesByPage() {

		Page<Class> page = new Page<>(1, 2);
		//page.setOrderByField("id");
		//page.setAsc(false);

		Class aClass = Class.builder().schoolId(1).build();

		Page<Class> aClasses = classService.getClassesByPage(page, aClass);
		System.err.println(JSON.toJSONString(aClasses));
		System.err.println("总记录数：" + page.getTotal());
		page.getRecords().forEach(cla -> System.err.println(JSON.toJSON(cla)));
	}

	/**
	 * 根据主键字段选择更新
	 * <p>
	 *     UPDATE T_CLASS  SET school_id=2  WHERE id=9;
	 * </p>
	 */
	@Test
	public void testUpdateById() {

		Class aClass = Class.builder().id(9).schoolId(2).build();

		classService.updateById(aClass);
	}

	/**
	 * 所有字段更新
	 * <p>
	 *     UPDATE T_CLASS  SET name=null,school_id=2  WHERE id=9;
	 * </p>
	 */
	@Test
	public void testUpdateAllColumnById() {

		Class aClass = Class.builder().id(9).schoolId(2).build();

		classService.updateAllColumnById(aClass);
	}

	/**
	 * 根据主键删除
	 * <p>
	 *     DELETE FROM T_CLASS WHERE id=9;
	 * </p>
	 */
	@Test
	public void testDeleteById() {

		classService.deleteById(9);
	}

	/**
	 * 根据主键批量删除
	 * <p>
	 *     DELETE FROM T_CLASS WHERE id IN (10, 11, 12);
	 * </p>
	 */
	@Test
	public void testDeleteBatchIds() {

		classService.deleteBatchIds(Lists.newArrayList(10, 11, 12));
	}

	/**
	 * 字段选择删除
	 * <p>
	 *     DELETE FROM T_CLASS WHERE  school_id=4;
	 * </p>
	 */
	@Test
	public void testDelete() {

		Class aClass = Class.builder().schoolId(4).build();

		classService.delete(aClass);
	}
}
