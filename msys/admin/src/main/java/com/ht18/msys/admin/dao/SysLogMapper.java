package com.ht18.msys.admin.dao;

import java.util.List;

import com.ht18.msys.admin.model.SysLog;

/**
 * ---------------------------
 * 系统日志 (SysLogMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysLogMapper {

	/**
	 * 添加系统日志
	 * @param record
	 * @return
	 */
    int add(SysLog record);

    /**
     * 删除系统日志
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改系统日志
     * @param record
     * @return
     */
    int update(SysLog record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysLog findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysLog> findPage();
    
}