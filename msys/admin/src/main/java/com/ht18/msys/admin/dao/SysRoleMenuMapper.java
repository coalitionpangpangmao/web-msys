package com.ht18.msys.admin.dao;

import java.util.List;

import com.ht18.msys.admin.model.SysRoleMenu;

/**
 * ---------------------------
 * 角色菜单 (SysRoleMenuMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysRoleMenuMapper {

	/**
	 * 添加角色菜单
	 * @param record
	 * @return
	 */
    int add(SysRoleMenu record);

    /**
     * 删除角色菜单
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改角色菜单
     * @param record
     * @return
     */
    int update(SysRoleMenu record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysRoleMenu findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysRoleMenu> findPage();
    
}