package com.bin.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bin.mybatis.plus.entity.Class;
import com.bin.mybatis.plus.mapper.ClassMapper;
import com.bin.mybatis.plus.service.ClassService;
import com.bin.mybatis.plus.util.EntityWrapperUtil;
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
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassMapper classMapper;

	@Override
	public int insert(Class aClass) {
		return classMapper.insertAllColumn(aClass);
	}

	@Override
	public int insertSelective(Class aClass) {
		return classMapper.insert(aClass);
	}

	@Override
	public Class getClassById(Integer id) {
		return classMapper.selectById(id);
	}

	@Override
	public List<Class> getAllClasses() {
		return classMapper.selectList(null);
	}

	@Override
	public List<Class> getClassesByCon(Class aClass) {
		return classMapper.selectList(new EntityWrapper<>(aClass));
	}

	@Override
	public List<Class> getClassesByCon2Map(Class aClass) {
		return classMapper.selectList(EntityWrapperUtil.getEqMapEntityWrapper(aClass));
	}

	@Override
	public List<Class> getClassesByMap(Map<String, Object> map) {
		return classMapper.selectList(EntityWrapperUtil.getEqMapEntityWrapper(map));
	}

	@Override
	public List<Class> getClassesByMap2(Map<String, Object> map) {
		//value为空不会参与条件比较
		return classMapper.selectByMap(map);
	}

	@Override
	public Integer getClassCountByCon(Class aClass) {
		return classMapper.selectCount(new EntityWrapper<>(aClass));
	}

	@Override
	public Page<Class> getClassesByPage(Page<Class> page, Class aClass) {
		page.setRecords(classMapper.selectPage(page, new EntityWrapper<>(aClass)));
		return page;
	}

	@Override
	public boolean updateById(Class aClass) {
		return classMapper.updateById(aClass) == 1;
	}

	@Override
	public boolean updateAllColumnById(Class aClass) {
		return classMapper.updateAllColumnById(aClass) == 1;
	}

	@Override
	public boolean deleteById(Integer id) {
		return classMapper.deleteById(id) == 1;
	}

	@Override
	public boolean deleteBatchIds(List<Integer> ids) {
		return classMapper.deleteBatchIds(ids) > 0;
	}

	@Override
	public boolean delete(Class aClass) {
		return classMapper.delete(new EntityWrapper<>(aClass)) > 0;
	}

}
