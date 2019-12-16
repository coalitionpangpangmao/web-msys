package com.ht18.msys.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht18.msys.admin.core.MybatisPageHelper;
import com.ht18.msys.admin.core.PageRequest;
import com.ht18.msys.admin.core.PageResult;

import com.ht18.msys.admin.model.SysRole;
import com.ht18.msys.admin.dao.SysRoleMapper;
import com.ht18.msys.admin.service.SysRoleService;

/**
 * ---------------------------
 * 角色管理 (SysRoleServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public int save(SysRole record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysRoleMapper.add(record);
		}
		return sysRoleMapper.update(record);
	}

	@Override
	public int delete(SysRole record) {
		return sysRoleMapper.delete(record.getId());
	}

	@Override
	public int delete(List<SysRole> records) {
		for(SysRole record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysRole findById(Long id) {
		return sysRoleMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
	}
	
}
