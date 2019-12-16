package com.ht18.msys.admin.dao;

import java.util.List;

import com.ht18.msys.admin.model.SysDept;

/**
 * ---------------------------
 * 机构管理 (SysDeptMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:06
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysDeptMapper {

	/**
	 * 添加机构管理
	 * @param record
	 * @return
	 */
    int add(SysDept record);

    /**
     * 删除机构管理
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改机构管理
     * @param record
     * @return
     */
    int update(SysDept record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysDept findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysDept> findPage();
    
}