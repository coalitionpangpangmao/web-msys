package com.ht18.msys.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ht18.msys.admin.core.HttpResult;
import com.ht18.msys.admin.core.PageRequest;

import com.ht18.msys.admin.model.SysRoleDept;
import com.ht18.msys.admin.service.SysRoleDeptService;

/**
 * ---------------------------
 * 角色机构 (SysRoleDeptController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("sysRoleDept")
public class SysRoleDeptController {

	@Autowired
	private SysRoleDeptService sysRoleDeptService;

	/**
	 * 保存角色机构
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysRoleDept record) {
		return HttpResult.ok(sysRoleDeptService.save(record));
	}

    /**
     * 删除角色机构
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysRoleDept> records) {
		return HttpResult.ok(sysRoleDeptService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysRoleDeptService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(sysRoleDeptService.findById(id));
	}
}
