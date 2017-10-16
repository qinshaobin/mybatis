package com.bin.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bin.mybatis.plus.entity.School;
import com.bin.mybatis.plus.mapper.SchoolMapper;
import com.bin.mybatis.plus.model.SchCla;
import com.bin.mybatis.plus.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author shaobin.qin
 */
@Service
@Slf4j
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {

	@Override
	public SchCla getSchClasById(int id) {

		return baseMapper.getSchClasById(id);
	}
}
