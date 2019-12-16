package com.ht18.msys.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht18.msys.admin.core.MybatisPageHelper;
import com.ht18.msys.admin.core.PageRequest;
import com.ht18.msys.admin.core.PageResult;

import com.ht18.msys.admin.model.SysRoleMenu;
import com.ht18.msys.admin.dao.SysRoleMenuMapper;
import com.ht18.msys.admin.service.SysRoleMenuService;

/**
 * ---------------------------
 * 角色菜单 (SysRoleMenuServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public int save(SysRoleMenu record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysRoleMenuMapper.add(record);
		}
		return sysRoleMenuMapper.update(record);
	}

	@Override
	public int delete(SysRoleMenu record) {
		return sysRoleMenuMapper.delete(record.getId());
	}

	@Override
	public int delete(List<SysRoleMenu> records) {
		for(SysRoleMenu record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysRoleMenu findById(Long id) {
		return sysRoleMenuMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysRoleMenuMapper);
	}
	
}
