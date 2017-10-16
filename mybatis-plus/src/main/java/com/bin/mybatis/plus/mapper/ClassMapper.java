package com.bin.mybatis.plus.mapper;

import com.bin.mybatis.plus.entity.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shaobin.qin
 */
@Mapper
public interface ClassMapper extends BaseMapper<Class> {

	List<Class> getClassBySchoolId(int shcoolId);
}
