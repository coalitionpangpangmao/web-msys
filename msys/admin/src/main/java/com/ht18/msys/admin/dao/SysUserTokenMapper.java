package com.ht18.msys.admin.dao;

import java.util.List;

import com.ht18.msys.admin.model.SysUserToken;
import org.apache.ibatis.annotations.Param;

/**
 * ---------------------------
 * 用户Token (SysUserTokenMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysUserTokenMapper {

	/**
	 * 添加用户Token
	 * @param record
	 * @return
	 */
    int add(SysUserToken record);

    /**
     * 删除用户Token
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改用户Token
     * @param record
     * @return
     */
    int update(SysUserToken record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysUserToken findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysUserToken> findPage();
    SysUserToken findByUserId(@Param(value="userId") Long userId);

    SysUserToken findByToken(@Param(value="token") String token);
}