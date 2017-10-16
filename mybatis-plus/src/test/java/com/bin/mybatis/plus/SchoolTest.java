package com.bin.mybatis.plus;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bin.mybatis.plus.entity.School;
import com.bin.mybatis.plus.model.SchCla;
import com.bin.mybatis.plus.service.SchoolService;
import com.bin.mybatis.plus.util.EntityWrapperUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author shaobin.qin
 */
public class SchoolTest extends BaseTest {

	@Autowired
	private SchoolService schoolService;

	/**
	 * 所有字段插入
	 * <p>
	 *     INSERT INTO T_SCHOOL (name)  VALUES ('sch3');
	 * </p>
	 */
	@Test
	public void testInsert() {

		School school = School.builder().name("sch3").build();

		schoolService.insertAllColumn(school);
	}

	/**
	 * 选择字段插入
	 * <p>
	 *     INSERT INTO T_SCHOOL (name)  VALUES ('sch3');
	 * </p>
	 */
	@Test
	public void testInsertSelective() {

		School school = School.builder().name("sch3").build();

		schoolService.insert(school);
	}

	/**
	 * 插入或更新记录，如果主键不为空则更新，否则插入
	 * <p>
	 *     UPDATE T_SCHOOL  SET name='sch11'  WHERE id=0;
	 *     INSERT INTO T_SCHOOL ( name )  VALUES ( 'sch11' );
	 * </p>
	 */
	@Test
	public void testInsertOrUpdateById() {

		// id不为空，更新
		School updateSchool = School.builder().id(1).name("sch11").build();

		schoolService.insertOrUpdate(updateSchool);

		// id为空，插入
		School insertSchool = School.builder().name("sch11").build();

		schoolService.insertOrUpdate(insertSchool);
	}

	/**
	 * 批量插入，该方法不适合 Oracle
	 * <p>
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch10' );
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch11' );
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch12' );
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch13' );
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch14' );
	 * </p>
	 */
	@Test
	public void testInsertBatch() {

		List<School> schools = Lists.newArrayList();
		for(int i=10; i<15; i++)
			schools.add(School.builder().name("sch" + i).build());

		schoolService.insertBatch(schools);
		schools.forEach(school -> System.err.println(JSON.toJSON(school)));
	}

	/**
	 * 批量插入，该方法不适合 Oracle
	 * <p>
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch10' );
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch11' );
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch12' );
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch13' );
	 *     INSERT INTO T_SCHOOL( name )  VALUES ( 'sch14' );
	 * </p>
	 */
	@Test
	public void testInsertBatch2() {

		List<School> schools = Lists.newArrayList();
		for(int i=10; i<15; i++)
			schools.add(School.builder().name("sch" + i).build());

		schoolService.insertBatch(schools, 2);
		schools.forEach(school -> System.err.println(JSON.toJSON(school)));
	}

	/**
	 * 根据主键查询记录
	 * <p>
	 *     SELECT id,name FROM T_SCHOOL WHERE id=1;
	 * </p>
	 */
	@Test
	public void testGetSchoolById() {

		School school = schoolService.selectById(1);

		System.err.println(JSON.toJSONString(school));
	}

	/**
	 * 查询所有记录
	 * <p>
	 *     SELECT  id,name  FROM T_SCHOOL;
	 * </p>
	 */
	@Test
	public void testGetAllSchools() {

		List<School> schools = schoolService.selectList(null);

		schools.forEach(school -> System.err.println(JSON.toJSON(school)));
	}

	/**
	 * 字段选择查询
	 * <p>
	 *     SELECT  id,name  FROM T_SCHOOL WHERE id=1;
	 * </p>
	 */
	@Test
	public void testGetSchoolsByCon() {

		School school = School.builder().id(1).name(null).build();
		List<School> schools = schoolService.selectList(new EntityWrapper<>(school));

		schools.forEach(sch -> System.err.println(JSON.toJSON(sch)));
	}

	/**
	 * 字段选择查询：序列化时属性名一定要和数据库字段名相同，属性为空的不参与条件比较
	 * eg:FastJson可以使用@JSONField(name='???')处理
	 * <p>
	 *     SELECT  id,name  FROM T_SCHOOL WHERE  (id = 1);
	 * </p>
	 */
	@Test
	public void testGetSchoolsByCon2Map() {

		School school = School.builder().id(1).name(null).build();
		List<School> schools = schoolService.selectList(EntityWrapperUtil.getEqMapEntityWrapper(school));

		schools.forEach(sch -> System.err.println(JSON.toJSON(sch)));
	}

	/**
	 * 字段选择查询：key必须跟数据库字段一致，key为null不参与条件比较
	 * <p>
	 *     SELECT  id,name  FROM T_SCHOOL WHERE ID = 1;;
	 * </p>
	 */
	@Test
	public void testGetClasssByMap() {

		Map<String, Object> map = Maps.newHashMap();
		map.put("ID", 1);
		map.put("NAME", null);
		List<School> schools = schoolService.selectByMap(map);

		schools.forEach(sch -> System.err.println(JSON.toJSON(sch)));
	}

	/**
	 * 根据条件查询记录数
	 * <p>
	 *     SELECT COUNT(1) FROM T_SCHOOL WHERE id=1;
	 * </p>
	 */
	@Test
	public void testGetClassCountByCon() {

		School school = School.builder().id(1).name(null).build();

		System.err.println("符合条件的记录数：" + schoolService.selectCount(new EntityWrapper<>(school)));
	}

	@Test
	public void testGetClassesByPage() {

		Page<School> page = new Page<>(1, 2);
		//page.setOrderByField("id");
		//page.setAsc(false);

		School school = School.builder().id(1).name(null).build();

		page = schoolService.selectPage(page, new EntityWrapper<>(school));
		System.err.println(JSON.toJSONString(page));
		System.err.println("总记录数：" + page.getTotal());
		page.getRecords().forEach(sch -> System.err.println(JSON.toJSON(sch)));
	}

	/**
	 * 字段选择更新
	 * <p>
	 *     UPDATE T_SCHOOL  SET name='sch11'  WHERE id=1;
	 * </p>
	 */
	@Test
	public void testUpdateById() {

		School school = School.builder().id(1).name("sch11").build();

		System.err.println(schoolService.updateById(school));
	}

	/**
	 * 字段选择更新(乐观锁模式)
	 * <p>
	 *     UPDATE T_SCHOOL  SET name='sch11', version=3  WHERE id=1  and version=2;
	 * </p>
	 */
	@Test
	public void testVersionUpdateById() {

		School school = School.builder().id(1).name("sch11").version(2).build();

		System.err.println(schoolService.updateById(school));
	}

	/**
	 * 所有字段更新
	 * <p>
	 *     UPDATE T_SCHOOL  SET name=null  WHERE id=1;
	 * </p>
	 */
	@Test
	public void testUpdateAllColumnById() {

		School school = School.builder().id(1).build();

		schoolService.updateAllColumnById(school);
	}

	/**
	 * 根据主键删除
	 * <p>
	 *     DELETE FROM T_SCHOOL WHERE id=10;
	 * </p>
	 */
	@Test
	public void testDeleteById() {

		schoolService.deleteById(10);
	}

	/**
	 * 根据主键批量删除
	 * <p>
	 *     DELETE FROM T_SCHOOL WHERE id IN (10, 11, 12);
	 * </p>
	 */
	@Test
	public void testDeleteBatchIds() {

		schoolService.deleteBatchIds(Lists.newArrayList(10, 11, 12));
	}

	/**
	 * 字段选择删除
	 * <p>
	 *     DELETE FROM T_SCHOOL WHERE  id=10;
	 * </p>
	 */
	@Test
	public void testDelete() {

		School school = School.builder().id(10).build();

		schoolService.delete(new EntityWrapper<>(school));
	}

	@Test
	public void testGetSchClasById() {

		SchCla schCla = schoolService.getSchClasById(1);
		System.err.println(JSON.toJSONString(schCla));
	}
}
