package com.ppw.blogknow.service.serviceImpl;

import com.ppw.blogknow.dao.TestMapper;
import com.ppw.blogknow.dao.TestMapper4Dept;
import com.ppw.blogknow.entity.Cust;
import com.ppw.blogknow.entity.Dept;
import com.ppw.blogknow.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/11 14:16 <br>
 * @see com.ppw.blogknow.service.serviceImpl <br>
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestMapper4Dept testMapper4Dept;
    @Override
    public void testSave(Cust cust) {
        Dept dept = new Dept();
        dept.setDeptName("CSC3");
        dept.setCustId(1L);
        dept.setCreateDate("2020/11/12 20:14:11");

        testMapper.testInsert(cust);
        int i = 1/0;
        testMapper4Dept.insert(dept);
    }

    @Override
    public Cust testMybatisPlus() {
        return (Cust)testMapper.selectById(1);
    }

    @Override
    public void testInsert4Dept(Dept dept) {
        testMapper4Dept.insert(dept);
    }
}
