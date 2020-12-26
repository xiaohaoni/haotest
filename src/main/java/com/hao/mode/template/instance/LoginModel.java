package com.hao.mode.template.instance;

import lombok.Data;

/**
 * 封装进行登入控制所需要的数据
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-24 12:46
 **/
@Data
public class LoginModel {

    private String loginId;

    private String pwd;
}
