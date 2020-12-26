package com.hao.mode.template.instance;

/**
 * 普通用户登录控制的逻辑处理
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-24 12:57
 **/
public class NormalLogin extends LoginTemplate{
    @Override
    public LoginModel findLoginUser(String id) {
        LoginModel lm = new LoginModel();
        lm.setLoginId(id);
        lm.setPwd("123456");
        return lm;
    }
}
