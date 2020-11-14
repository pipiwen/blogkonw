package com.ppw.blogknow.controller;

import com.ppw.blogknow.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/13 14:32 <br>
 * @see com.ppw.blogknow.controller <br>
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    public String loginAuth(User user) {
        if (null == user) {

        }
        return null;
    }
}
