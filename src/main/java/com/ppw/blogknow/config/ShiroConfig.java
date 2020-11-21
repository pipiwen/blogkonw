package com.ppw.blogknow.config;

import com.ppw.blogknow.persistent.Encrypt;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/18 12:11 <br>
 * @see com.ppw.blogknow.config <br>
 */
@Configuration
public class ShiroConfig {
    // 3.shiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //暂时写死(之后可以考虑采用配置方式)
        map.put("/resources/**","anon");
        map.put("/static/**","anon");
        map.put("/login/loginPage","anon");
        map.put("/login/loginIn","anon");
        map.put("/login/register","anon");
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setLoginUrl("/login/loginPage");
        return shiroFilterFactoryBean;
    }

    // 2.DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("sysUserRealm") SysUserRealm sysUserRealm) {
        //固定写法关联realm
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(sysUserRealm);
        return securityManager;
    }
    // 1.Realm
    @Bean
    public SysUserRealm sysUserRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
        SysUserRealm sysUserRealm = new SysUserRealm();
        sysUserRealm.setCredentialsMatcher(matcher);
        return sysUserRealm;
    }

    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName(Encrypt.MD5);
        //加密次数
        credentialsMatcher.setHashIterations(Encrypt.HASH_ITERATIONS);
        return credentialsMatcher;
    }
}
