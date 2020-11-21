package com.ppw.blogknow.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ppw.blogknow.dao.SysUserMapper;
import com.ppw.blogknow.entity.SysUser;
import com.ppw.blogknow.service.SysUserService;
import com.ppw.blogknow.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/18 19:11 <br>
 * @see com.ppw.blogknow.service.serviceImpl <br>
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional //加入事务放入同一个sqlSession中
    public void loginIn(SysUser user) {
        //获取shiro门面
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        //执行认证会跳转doGetAuthenticationInfo()方法
        subject.login(token);
        this.updateLoginTime();
    }

    @Override
    public SysUser get(SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(sysUser);
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public List<SysUser> selectList(SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(sysUser);
        return sysUserMapper.selectList(queryWrapper);
    }

    @Override
    public Integer sysUserSave(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public Integer updateLoginTime() {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        user.setLastLoginTime(DateUtil.datetoStr());


        return sysUserMapper.recordLastLoginTime(user);
    }
}
