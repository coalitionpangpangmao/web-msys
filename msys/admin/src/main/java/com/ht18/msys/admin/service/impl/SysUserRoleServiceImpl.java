package com.ht18.msys.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht18.msys.admin.core.MybatisPageHelper;
import com.ht18.msys.admin.core.PageRequest;
import com.ht18.msys.admin.core.PageResult;

import com.ht18.msys.admin.model.SysUserRole;
import com.ht18.msys.admin.dao.SysUserRoleMapper;
import com.ht18.msys.admin.service.SysUserRoleService;

/**
 * ---------------------------
 * 用户角色 (SysUserRoleServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public int save(SysUserRole record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysUserRoleMapper.insert(record);
		}
		return sysUserRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysUserRole record) {
		return sysUserRoleMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysUserRole> records) {
		for(SysUserRole record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysUserRole findById(Long id) {
		return sysUserRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysUserRoleMapper);
	}
	
}
