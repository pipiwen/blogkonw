package com.ppw.blogknow.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/11 14:14 <br>
 * @see com.ppw.blogknow.entity <br>
 */
public class Cust {

    private Long id;
    private String custName;
    private Integer age;

    @JSONField(format = "yyyy年MM月dd日")
    private Date birth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
