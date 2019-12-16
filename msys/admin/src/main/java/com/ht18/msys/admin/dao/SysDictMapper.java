package com.ht18.msys.admin.dao;

import java.util.List;

import com.ht18.msys.admin.model.SysDict;

/**
 * ---------------------------
 * 字典表 (SysDictMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:06
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysDictMapper {

	/**
	 * 添加字典表
	 * @param record
	 * @return
	 */
    int add(SysDict record);

    /**
     * 删除字典表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改字典表
     * @param record
     * @return
     */
    int update(SysDict record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysDict findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysDict> findPage();
    
}