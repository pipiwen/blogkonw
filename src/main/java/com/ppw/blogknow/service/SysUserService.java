package com.ppw.blogknow.service;

import com.ppw.blogknow.entity.SysUser;

import java.util.List;

public interface SysUserService {
    void loginIn(SysUser user);

    SysUser get(SysUser sysUser);

    List<SysUser> selectList(SysUser sysUser);

    Integer sysUserSave(SysUser sysUser);

    Integer updateLoginTime();
}
