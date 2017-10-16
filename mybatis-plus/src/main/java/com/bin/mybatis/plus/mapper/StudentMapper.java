package com.bin.mybatis.plus.mapper;

import com.bin.mybatis.plus.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * ActiveRecord模式
 * bug? 如果没有，启动会报错。
 * @author shaobin.qin
 */
@Mapper
@SuppressWarnings("unused")
public interface StudentMapper extends BaseMapper<Student> {
}
