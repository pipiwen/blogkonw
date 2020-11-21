package com.ppw.blogknow.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ppw.blogknow.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    Integer recordLastLoginTime (SysUser sysUser);
}
