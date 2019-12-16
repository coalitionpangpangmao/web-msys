package com.ht18.msys.admin.service;

import com.ht18.msys.admin.model.SysUserToken;
import com.ht18.msys.admin.core.CurdService;

/**
 * ---------------------------
 * 用户Token (SysUserTokenService)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysUserTokenService extends CurdService<SysUserToken> {
    /**
     * 根据用户id查找
     * @param userId
     * @return
     */
    SysUserToken findByUserId(Long userId);

    /**
     * 根据token查找
     * @param token
     * @return
     */
    SysUserToken findByToken(String token);

    /**
     * 生成token
     * @param userId
     * @return
     */
    SysUserToken createToken(long userId);
}
