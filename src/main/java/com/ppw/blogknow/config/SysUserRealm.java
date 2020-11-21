package com.ppw.blogknow.config;

import com.ppw.blogknow.entity.SysUser;
import com.ppw.blogknow.persistent.Encrypt;
import com.ppw.blogknow.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/18 12:17 <br>
 * @see com.ppw.blogknow.config <br>
 */
public class SysUserRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(SysUserRealm.class);

    @Autowired
    private SysUserService sysUserService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.debug("执行授权==> doGetAuthorizationInfo");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug("执行认证==> doGetAuthenticationInfo");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;


        SysUser user1 = new SysUser();

        user1.setUsername(token.getUsername());
        SysUser sysUser = sysUserService.get(user1);
        if (null == sysUser) {
            return null;//抛出异常(用户名不存在)
        }

        return new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),
                ByteSource.Util.bytes(sysUser.getUsername()),getName());
    }
}
