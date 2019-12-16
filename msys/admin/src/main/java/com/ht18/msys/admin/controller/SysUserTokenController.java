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

import com.ht18.msys.admin.model.SysUserToken;
import com.ht18.msys.admin.service.SysUserTokenService;

/**
 * ---------------------------
 * 用户Token (SysUserTokenController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("sysUserToken")
public class SysUserTokenController {

	@Autowired
	private SysUserTokenService sysUserTokenService;

	/**
	 * 保存用户Token
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysUserToken record) {
		return HttpResult.ok(sysUserTokenService.save(record));
	}

    /**
     * 删除用户Token
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysUserToken> records) {
		return HttpResult.ok(sysUserTokenService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysUserTokenService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(sysUserTokenService.findById(id));
	}
}
