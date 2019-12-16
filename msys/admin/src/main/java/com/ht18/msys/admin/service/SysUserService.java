package com.ht18.msys.admin.service;

import com.ht18.msys.admin.model.SysUser;
import com.ht18.msys.admin.core.CurdService;
import com.ht18.msys.admin.model.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 * ---------------------------
 * 用户管理 (SysUserService)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysUserService extends CurdService<SysUser> {
    SysUser findByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     * @param userName
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);
}
