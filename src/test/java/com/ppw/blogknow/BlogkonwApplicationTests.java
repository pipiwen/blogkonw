package com.ppw.blogknow;

import com.ppw.blogknow.dao.UserMapper;
import com.ppw.blogknow.service.serviceImpl.TestServiceImpl;
import com.ppw.blogknow.util.SpringContextUtils;
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
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println("begin...");
        int i = userMapper.deleteById(2);
        System.out.println("LogicDelete num is : " + i);
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
}
