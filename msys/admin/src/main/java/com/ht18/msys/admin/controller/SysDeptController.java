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



import com.ht18.msys.admin.model.SysDept;
import com.ht18.msys.admin.service.SysDeptService;
import com.ht18.msys.admin.core.HttpResult;
import com.ht18.msys.admin.core.PageRequest;


/**
 * ---------------------------
 * 机构管理 (SysDeptController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:06
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("sysDept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;

	/**
	 * 保存机构管理
	 * @param record
	 * @return
	 */

	@RequiresPermissions({"sys:dept:add","sys:dept:edit"})
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysDept record) {
		return HttpResult.ok(sysDeptService.save(record));
	}

    /**
     * 删除机构管理
     * @param records
     * @return
     */

	@RequiresPermissions("sys:dept:delete")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysDept> records) {
		return HttpResult.ok(sysDeptService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */
	@RequiresPermissions("sys:dept:view")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysDeptService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */
	@RequiresPermissions("sys:dept:view")
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(sysDeptService.findById(id));
	}
}
