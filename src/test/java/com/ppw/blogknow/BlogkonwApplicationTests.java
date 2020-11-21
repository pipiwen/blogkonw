package com.ppw.blogknow;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ppw.blogknow.dao.SysUserMapper;
import com.ppw.blogknow.dao.TestMapper4SysUser;
import com.ppw.blogknow.entity.SysUser;
import com.ppw.blogknow.handler.BaseBusinessException;
import com.ppw.blogknow.persistent.Encrypt;
import com.ppw.blogknow.service.serviceImpl.TestServiceImpl;
import com.ppw.blogknow.util.SessionUtil;
import com.ppw.blogknow.util.SpringContextUtils;
import com.ppw.blogknow.util.UUIDUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BlogkonwApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(BlogkonwApplicationTests.class);

    @Autowired
    private TestMapper4SysUser testMapper4SysUser;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void mybatisTest(){

    }

    @Test
    void contextTest(){
        logger.info("begin context text...");
        TestServiceImpl testServiceBean = SpringContextUtils.getBean(TestServiceImpl.class);
        logger.info("testServiceBean :{}", testServiceBean);
    }

    @Test
    void testSysUser(){
        logger.info("begin testSysUser.............");

        SysUser sysUser = new SysUser();
        sysUser.setUserId(UUIDUtil.getUUID());
        sysUser.setUsername("王琦");
        sysUser.setPassword("123456");
        //int i = testMapper4SysUser.insert(sysUser);

        int i = testMapper4SysUser.deleteById(1);
        logger.info("end test result is : {}", i);

    }
    @Test
    void testException(){
        logger.info("begin testSysUser.............");

        throw  new BaseBusinessException(1001, "异常测试");

    }
    @Test
    void testQBCQuery(){
        logger.info("begin testSysUser.............");
        SysUser sysUser = new SysUser();
        sysUser.setUsername("wangqi");
        sysUser.setPassword("123456");
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(sysUser);
        SysUser user = sysUserMapper.selectOne(queryWrapper);
        System.out.println("-------------" + user.getUserId());
    }
    @Test
    void testShiroMD5(){
        logger.info("begin testSysUser.............");
        SimpleHash simpleHashPwd = new SimpleHash(Encrypt.MD5,
                "123456", "wangqi", Encrypt.HASH_ITERATIONS);
        logger.info("-------------simpleHashPwd:{}", simpleHashPwd);
    }
    @Test
    void testSession(){
        logger.info("begin testSession.............");
        logger.info("context path is: {}", SessionUtil.getContextPath());
        logger.info(SessionUtil.getIp());
        //logger.info(SessionUtil.getSession().getAttribute("username").toString());

    }


}
