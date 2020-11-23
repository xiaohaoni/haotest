package com.hao.mode.combination;

import java.util.List;

/**
 * 抽象的组件对象
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-16 09:46
 **/
public abstract class Component {

    /**
     * 记录父组件对象
     * */
    private Component parent = null;

    /**
     * 获取一个组件的对象 get set方法
     *
     * */
    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }

    /**
     * 返回某个组件的子组件对象
     * @return 某个组件的子组件对象
     * */
    public List<Component> getChildren(){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 输出组件自身的名称
     * */
    public abstract void printStruct(String preStr);

    /**
     * 想组合对象中加入组件对象
     *
     * */
    public void addChild(Component child){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 从组合对象中移除某个组件对象
     * @param child  被移出来的组件对象
     * */
    public void removeChild(Component child){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 返回某个 所有对应的组件对象
     * @param index 需要获取组件对象的所有，所有从0开始
     * @return 索引对应的组件对象
     * */
    public Component getChildren(int index){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
}
