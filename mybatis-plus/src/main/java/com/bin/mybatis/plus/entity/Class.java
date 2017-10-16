package com.bin.mybatis.plus.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 使用@TableId指定主键，也可以不用，但主键必须叫 id 忽略大小写
 * @author shaobin.qin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("T_CLASS")
public class Class {

	@TableId
	private Integer id;

	private String name;

	// 学校id
	@JSONField(name = "SCHOOL_ID")
	private Integer schoolId;

	private Integer version;
}
