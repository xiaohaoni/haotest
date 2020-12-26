package com.hao.mode.template.instance;

/**
 * 登录控制的模板
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-24 12:47
 **/
public abstract class LoginTemplate {
    /**
     * 判断用户登入数据是否正确
     */
    public final boolean login(LoginModel lm) {
        LoginModel dblm = this.findLoginUser(lm.getLoginId());
        if (dblm != null) {
            String encryptPwd = this.encryptPwd(lm.getPwd());
            lm.setPwd(encryptPwd);
            return this.match(lm, dblm);
        }
        return false;
    }

    /**
     * 判断用户填写的登录数据和存储中对象的数据是否匹配的上
     * @param lm  用户填写的登录数据
     * @param dblm 在存储中对象的数据
     * @return  true/false
     * */
    protected boolean match(LoginModel lm, LoginModel dblm) {
        if (lm.getLoginId().equals(dblm.getLoginId()) && lm.getPwd().equals(dblm.getPwd())){
            return true;
        }
        return false;

    }

    ;

    /**
     * 根据登录编号来查找和获取存储中相应的数据
     *
     * @param id 登录编号
     */
    public abstract LoginModel findLoginUser(String id);

    /**
     * 密码加密
     */
    public String encryptPwd(String pwd) {
        return pwd;
    }
}
