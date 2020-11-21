package com.ppw.blogknow.controller;

import com.ppw.blogknow.entity.SysUser;
import com.ppw.blogknow.handler.BaseBusinessException;
import com.ppw.blogknow.service.SysUserService;
import com.ppw.blogknow.util.CollectionUtil;
import com.ppw.blogknow.util.MD5Encrypt;
import com.ppw.blogknow.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/loginPage")
    public String loginPage() {

        return "cust/login/login1";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(SysUser user) {
        try {
            if (null == user) {
                throw  new BaseBusinessException(1001, "user为空");
            }
            SysUser user1 = new SysUser();
            user1.setUsername(user.getUsername());
            if (CollectionUtil.isNotEmpty(sysUserService.selectList(user1))) {
                return "receipt";
            }
            SysUser user4Register = new SysUser();
            user4Register.setUserId(UUIDUtil.getUUID());
            user4Register.setUsername(user.getUsername());
            user4Register.setPassword(MD5Encrypt.simpleHash(user.getPassword(), user.getUsername()));
            sysUserService.sysUserSave(user4Register);
            return "success";
        } catch (Exception e) {

            return "fail";
        }
    }
    @PostMapping("/loginIn")
    @ResponseBody
    public String loginIn(SysUser user) {
        try {
            if (null == user) {
                throw new BaseBusinessException(1001, "user为空");
            }
            sysUserService.loginIn(user);

            return "success";
        } catch (Exception e) {

            return "fail";
        }
    }

    @GetMapping("/indexPage")
    public String indexPage() {

        return "cust/homepage/indexPage";
    }

}
