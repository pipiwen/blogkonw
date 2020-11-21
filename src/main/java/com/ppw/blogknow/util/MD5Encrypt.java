package com.ppw.blogknow.util;

import com.ppw.blogknow.persistent.Encrypt;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/20 23:17 <br>
 * @see com.ppw.blogknow.util <br>
 */
public class MD5Encrypt {

    public static String simpleHash(String source,String salt) {

        return new SimpleHash(Encrypt.MD5,
                source, salt, Encrypt.HASH_ITERATIONS).toString();
    }
}
