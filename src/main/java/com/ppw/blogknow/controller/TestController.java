package com.ppw.blogknow.controller;

import com.ppw.blogknow.dao.UserMapper;
import com.ppw.blogknow.entity.Cust;
import com.ppw.blogknow.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/11 12:21 <br>
 * @see com.ppw.blogknow.controller <br>
 */
@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    @Qualifier("testServiceImpl")
    private TestService testService;
    @Autowired
    private UserMapper userMapper;

    //测试新建的web工程采用boot项目采用外置tomcat
    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        //测试下日志输出
        logger.trace("trace-log");
        logger.debug("trace-debug");
        logger.info("trace-info");
        logger.warn("trace-warn");
        logger.error("trace-error");

        return "Hello World！！！";
    }
    /***
     * Description <br>
     * 测试数据库
     **/
    @RequestMapping(value = "/testInsert")
    @ResponseBody
    public String test1() {
        Cust cust = new Cust();
        cust.setCustName("Sam");
        cust.setAge(22);
        testService.testSave(cust);
        return "Test Insert";
    }

    @RequestMapping(value = "/selectOne")
    @ResponseBody
    public Cust testMybatisPlus() {

        return testService.testMybatisPlus();
    }
    /***
     * Description <br>
     * 测试fastJson
     **/
    @RequestMapping(value = "/testJson")
    @ResponseBody
    public Cust testJson() {
        Cust cust = new Cust();
        cust.setId(123L);
        cust.setAge(45);
        cust.setCustName("张飒");
        cust.setBirth(new Date());
        logger.debug("显示时间对比:--------: {}", new Date());
        return cust;
    }

    /***
     * Description <br>
     * 测试事务
     **/
    @RequestMapping(value = "/testTrans")
    @ResponseBody
    public void txMgt() {
        Cust cust = new Cust();
        cust.setCustName("Dudo555");
        cust.setAge(20);
        testService.testSave(cust);
    }
    /***
     * Description <br>
     * 测试主页面
     **/
    @RequestMapping(value = "/index")
    public String indexPage() {
        String s = "111";
        return "login";
    }

    @RequestMapping("/logicDelete")
    public void testLogicDelete() {

        int i = userMapper.deleteById(2);
        logger.debug("LogicDelete num is : {}", i);
    }
    @RequestMapping(value = "/test1111")
    public String test1111(Model model) {
        model.addAttribute("testInfo","hello syw");
        return "cust/login/testFreemarker";
    }

}
