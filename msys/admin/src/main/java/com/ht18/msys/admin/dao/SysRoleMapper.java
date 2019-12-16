package com.ht18.msys.admin.dao;

import java.util.List;

import com.ht18.msys.admin.model.SysRole;

/**
 * ---------------------------
 * 角色管理 (SysRoleMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysRoleMapper {

	/**
	 * 添加角色管理
	 * @param record
	 * @return
	 */
    int add(SysRole record);

    /**
     * 删除角色管理
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改角色管理
     * @param record
     * @return
     */
    int update(SysRole record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysRole findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysRole> findPage();
    
}