package com.ht18.msys.admin.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ht18.msys.admin.core.HttpResult;
import com.ht18.msys.admin.core.PageRequest;

import com.ht18.msys.admin.model.SysMenu;
import com.ht18.msys.admin.service.SysMenuService;

/**
 * ---------------------------
 * 菜单管理 (SysMenuController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 保存菜单管理
	 * @param record
	 * @return
	 */
	@RequiresPermissions({"sys:menu:add","sys:role:edit"})
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysMenu record) {
		return HttpResult.ok(sysMenuService.save(record));
	}

    /**
     * 删除菜单管理
     * @param records
     * @return
     */
	@RequiresPermissions("sys:menu:delete")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysMenu> records) {
		return HttpResult.ok(sysMenuService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */
	@RequiresPermissions("sys:menu:view")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysMenuService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */
	@RequiresPermissions("sys:menu:view")
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(sysMenuService.findById(id));
	}
}
