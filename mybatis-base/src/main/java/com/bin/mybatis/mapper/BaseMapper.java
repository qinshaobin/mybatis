package com.bin.mybatis.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {

	T selectByPrimaryKey(BigDecimal key);

	List<T> selectList();

	List<T> selectListByCon(T t);

	List<T> selectListByCon(Map<String, Object> map);

	int deleteByPrimaryKey(BigDecimal key);
	
	int insert(T entity);

	int insertSelective(T entity);
	
	int updateByPrimaryKeySelective(T entity);
	
	int updateByPrimaryKey(T entity);
	
}
