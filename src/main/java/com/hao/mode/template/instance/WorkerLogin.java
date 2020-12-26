package com.hao.mode.template.instance;

/**
 * 工作人员登录控制的逻辑处理
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-24 12:59
 **/
public class WorkerLogin extends LoginTemplate{
    @Override
    public LoginModel findLoginUser(String id) {
        LoginModel lm = new LoginModel();
        lm.setLoginId(id);
        lm.setPwd("w123456");
        return lm;
    }

    @Override
    public String encryptPwd(String pwd){
        //覆盖父类加密算法
        System.out.println("进行MD5加密");
        return pwd;
    }
}
