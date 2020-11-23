package com.hao.mode.flyweight;

import com.hao.mode.decoraor.common.TempDB;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用享元对象  类似于client类
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-19 09:48
 **/
public class SecurityMgr {

    private static final SecurityMgr securityMgr = new SecurityMgr();
    private SecurityMgr(){}
    public static SecurityMgr getInstance(){
        return securityMgr;
    }

    /**
     * 在运行期间，用来存放登录人员对应的权限，
     * 在web应用中，这些数据通常会放到session中
     * */
    private Map<String, Collection<Flyweight>> map = new HashMap<String, Collection<Flyweight>>();

    /**
     * 模拟登录的功能
     * @param user 登入用户
     * */
    public void login(String user){
        Collection<Flyweight> col =queryByUser(user);
        map.put(user,col);
    }

    /**
     * 判断某用户对某个安全实体是否拥有某种权限
     * @param securityEntity 安全实体
     * @param user 用户
     * @param permit 权限
     * @return true/false
     * */
    public boolean hasPermit(String user,String securityEntity,String permit){
        Collection<Flyweight> col = map.get(user);
        if (col == null || col.size() == 0){
            System.out.println(user + "没有登录或是没有背分配任何权限");
            return false;
        }
        for (Flyweight fm : col){
            //输出当前实例，看看是否同一个实例对象
            System.out.println("fm"+fm);
            if (fm.match(securityEntity,permit)){
                return true;

            }
        }
        return false;
    }

    /**
     * 冲数据库中获取某人所拥有的权限
     * @param user 需要获取拥有的权限的人员
     * @return 某人拥有的权限
     * */
    public Collection<Flyweight> queryByUser(String user){
        Collection<Flyweight> col = new ArrayDeque<Flyweight>();
        for (String s : TestDB.colDb){
            String ss[] = s.split(",");
            if (ss[0].equals(user)){
                Flyweight fm = FlyweightFactory.getInstance().getFlyweight(ss[1]+","+ss[2]);
                col.add(fm);
            }

        }
        return col;
    }

}
