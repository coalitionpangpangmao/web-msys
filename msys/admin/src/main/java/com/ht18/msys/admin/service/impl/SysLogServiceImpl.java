package com.ht18.msys.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht18.msys.admin.core.MybatisPageHelper;
import com.ht18.msys.admin.core.PageRequest;
import com.ht18.msys.admin.core.PageResult;

import com.ht18.msys.admin.model.SysLog;
import com.ht18.msys.admin.dao.SysLogMapper;
import com.ht18.msys.admin.service.SysLogService;

/**
 * ---------------------------
 * 系统日志 (SysLogServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;

	@Override
	public int save(SysLog record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysLogMapper.add(record);
		}
		return sysLogMapper.update(record);
	}

	@Override
	public int delete(SysLog record) {
		return sysLogMapper.delete(record.getId());
	}

	@Override
	public int delete(List<SysLog> records) {
		for(SysLog record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLog findById(Long id) {
		return sysLogMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
	}
	
}
