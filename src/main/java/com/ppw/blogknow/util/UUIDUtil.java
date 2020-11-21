package com.ppw.blogknow.util;

import java.util.UUID;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/16 13:36 <br>
 * @see com.ppw.blogknow.util <br>
 */
public class UUIDUtil {
    /**
     * <Description> <br>
     * 生成16位的uuid
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }
}
