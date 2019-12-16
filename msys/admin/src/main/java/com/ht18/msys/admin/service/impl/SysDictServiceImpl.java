package com.ht18.msys.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht18.msys.admin.core.MybatisPageHelper;
import com.ht18.msys.admin.core.PageRequest;
import com.ht18.msys.admin.core.PageResult;

import com.ht18.msys.admin.model.SysDict;
import com.ht18.msys.admin.dao.SysDictMapper;
import com.ht18.msys.admin.service.SysDictService;

/**
 * ---------------------------
 * 字典表 (SysDictServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysDictServiceImpl implements SysDictService {

	@Autowired
	private SysDictMapper sysDictMapper;

	@Override
	public int save(SysDict record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysDictMapper.add(record);
		}
		return sysDictMapper.update(record);
	}

	@Override
	public int delete(SysDict record) {
		return sysDictMapper.delete(record.getId());
	}

	@Override
	public int delete(List<SysDict> records) {
		for(SysDict record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysDict findById(Long id) {
		return sysDictMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
	}
	
}
