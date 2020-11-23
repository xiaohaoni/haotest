package com.hao.mode.flyweight;

/**
 * 封装授权数据中重复出现部分数据得享元对象
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-19 09:37
 **/
public class AuthorizationFlyweight implements Flyweight{

    /**
     * 内部实体，安全实体
     * */
    private String securityEntity;

    /**
     * 内部状态 权限
     * */
    private String permit;
    /**
     * 构造方法，转入状态数据
     * @param state 状态数据，包含安全实体喝权限得数据，用 ”，“分隔
     * */
    public AuthorizationFlyweight(String state){
        String ss[] = state.split(",");
        securityEntity = ss[0];
        permit = ss[1];
    }

    public String getSecurityEntity() {
        return securityEntity;
    }

    public String getPermit() {
        return permit;
    }

    @Override
    public boolean match(String securityEntity, String permit) {
        return this.securityEntity.equals(securityEntity) && this.permit.equals(permit);
    }

    @Override
    public String toString() {
        return "AuthorizationFlyweight{" +
                "securityEntity='" + securityEntity + '\'' +
                ", permit='" + permit + '\'' +
                '}';
    }
}
