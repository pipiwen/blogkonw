package com.ppw.blogknow.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ppw.blogknow.controller.TestController;
import com.ppw.blogknow.util.DateUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/16 15:10 <br>
 * @see com.ppw.blogknow.config <br>
 */
@Configuration
public class AutoFillMetaObjectHandlerConfig implements MetaObjectHandler {
    private static final Logger logger = LoggerFactory.getLogger(AutoFillMetaObjectHandlerConfig.class);
    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("start insert fill ....");


        // setFieldValByName方法中参数分别为实体类的属性名、要填充的值，元数据对象
        this.setFieldValByName("createTime", DateUtil.datetoStr(), metaObject);
        this.setFieldValByName("updateTime", DateUtil.datetoStr(), metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("start insert fill ....");
        this.setFieldValByName("updateTime", DateUtil.datetoStr(), metaObject);
    }

}
