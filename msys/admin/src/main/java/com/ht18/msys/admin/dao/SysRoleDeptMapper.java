package com.ht18.msys.admin.dao;

import java.util.List;

import com.ht18.msys.admin.model.SysRoleDept;

/**
 * ---------------------------
 * 角色机构 (SysRoleDeptMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysRoleDeptMapper {

	/**
	 * 添加角色机构
	 * @param record
	 * @return
	 */
    int add(SysRoleDept record);

    /**
     * 删除角色机构
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改角色机构
     * @param record
     * @return
     */
    int update(SysRoleDept record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysRoleDept findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysRoleDept> findPage();
    
}