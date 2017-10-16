package com.bin.mybatis.plus.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.bin.mybatis.plus.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * ActiveRecord 模式 只适用于单表查询，且属性与表字段完全匹配。
 * bug? 如果没有对应的EntityMapper，启动会报错。
 * @author shaobin.qin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("T_STUDENT")
public class Student extends Model<Student> implements Serializable {

	private Integer id;

	private String name;

	private Integer age;

	@TableField("BIRTHDAY")
	@JSONField(format = Constants.DATEFORMAT1)
	private Date birthDay;

	@JSONField(name = "CREATE_TIME", format = Constants.DATEFORMAT2)
	private Date createTime;

	@JSONField(name = "CLASS_ID")
	private Integer classId;

	private Integer version;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
