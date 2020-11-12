package com.ppw.blogknow.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ppw.blogknow.entity.Cust;
import com.ppw.blogknow.entity.Dept;

public interface TestService {

    void testSave(Cust cust);

    void testInsert4Dept(Dept dept);

    Cust testMybatisPlus();
}
