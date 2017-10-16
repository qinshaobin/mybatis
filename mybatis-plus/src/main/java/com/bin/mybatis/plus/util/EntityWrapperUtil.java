package com.bin.mybatis.plus.util;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

/**
 * 基于ActiveRecord模式的mybatis-plus生成EntityWrapper的工具类
 * 局限性太大，不够通用。
 * @author shaobin.qin
 */
@Slf4j
public class EntityWrapperUtil {

	/**
	 * 传入实体类对象，生成EntityWrapper，属性为空的不参与条件比较
	 * 序列化时属性名一定要和数据库字段名相同
	 * eg:FastJson可以使用@JSONField(name='???')处理
	 */
	@SuppressWarnings("unchecked")
	public static <T> EntityWrapper<T> getEqMapEntityWrapper(T entity) {

		Map<String, Object> map = JSON.parseObject(JSON.toJSONString(entity), Map.class);
		return getEqMapEntityWrapper(map);
	}

	/**
	 * 传入Map对象，生成EntityWrapper，value为空的不参与条件比较
	 * map得key一定要和数据库字段名相同
	 */
	public static <T> EntityWrapper<T> getEqMapEntityWrapper(Map<String, Object> map) {

		EntityWrapper<T> entityWrapper = new EntityWrapper<>();
		for(Map.Entry<String, Object> entry : map.entrySet())
			if(entry.getValue() != null)
				entityWrapper.eq(entry.getKey(), entry.getValue());

		return entityWrapper;
	}
}
