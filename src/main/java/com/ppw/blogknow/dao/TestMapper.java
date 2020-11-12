package com.ppw.blogknow.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ppw.blogknow.entity.Cust;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper extends BaseMapper<Cust> {
    void testInsert(Cust cust);
}
