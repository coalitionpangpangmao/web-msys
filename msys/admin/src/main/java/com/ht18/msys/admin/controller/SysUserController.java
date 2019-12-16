package com.ht18.msys.admin.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ht18.msys.admin.core.HttpResult;
import com.ht18.msys.admin.core.PageRequest;

import com.ht18.msys.admin.model.SysUser;
import com.ht18.msys.admin.service.SysUserService;

/**
 * ---------------------------
 * 用户管理 (SysUserController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 保存用户管理
	 * @param record
	 * @return
	 */
//	@PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
	@RequiresPermissions({"sys:user:add","sys:user:edit"})
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysUser record) {
		return HttpResult.ok(sysUserService.save(record));
	}

    /**
     * 删除用户管理
     * @param records
     * @return
     */
//	@PreAuthorize("hasAuthority('sys:user:delete')")
	@RequiresPermissions("sys:user:delete")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysUser> records) {
		return HttpResult.ok(sysUserService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */
//	@PreAuthorize("hasAuthority('sys:user:view')")
	@RequiresPermissions("sys:user:view")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysUserService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */
//	@PreAuthorize("hasAuthority('sys:user:view')")
	@RequiresPermissions("sys:user:view")
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(sysUserService.findById(id));
	}
}
