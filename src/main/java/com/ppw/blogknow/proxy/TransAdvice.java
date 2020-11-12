package com.ppw.blogknow.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/11 18:39 <br>
 * @see com.ppw.blogknow.proxy <br>
 */
@Aspect
@Component
public class TransAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TransAdvice.class);
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;
    /**
     * 切点: 业务层增加事务
     */
    @Pointcut("execution(public * com.ppw.blogknow.service.serviceImpl.*.*Modify*(..)) ||" +
            "execution(public * com.ppw.blogknow.service.serviceImpl.*.*Save*(..))")
    public void transMgtAspect(){

    }

    /**
     * @description  使用环绕通知
     */
    @Around("transMgtAspect()")
    public void doTransMgt(ProceedingJoinPoint pjp) throws Throwable {
        TransactionStatus transactionStatus = null;
        try{
            //手动开启事务
            logger.debug("Manual transaction begin...");
            transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            //核心业务执行
            pjp.proceed();
            //手动提交
            dataSourceTransactionManager.commit(transactionStatus);
        }
        catch(Throwable e){
            logger.error("transcation commit fail...");
            //手动回滚事务
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }
}
