package com.ht18.msys.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht18.msys.admin.core.MybatisPageHelper;
import com.ht18.msys.admin.core.PageRequest;
import com.ht18.msys.admin.core.PageResult;

import com.ht18.msys.admin.model.SysRoleDept;
import com.ht18.msys.admin.dao.SysRoleDeptMapper;
import com.ht18.msys.admin.service.SysRoleDeptService;

/**
 * ---------------------------
 * 角色机构 (SysRoleDeptServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService {

	@Autowired
	private SysRoleDeptMapper sysRoleDeptMapper;

	@Override
	public int save(SysRoleDept record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysRoleDeptMapper.add(record);
		}
		return sysRoleDeptMapper.update(record);
	}

	@Override
	public int delete(SysRoleDept record) {
		return sysRoleDeptMapper.delete(record.getId());
	}

	@Override
	public int delete(List<SysRoleDept> records) {
		for(SysRoleDept record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysRoleDept findById(Long id) {
		return sysRoleDeptMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysRoleDeptMapper);
	}
	
}
