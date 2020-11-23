package com.hao.mode.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合对象，可以包含其他对象或者叶子对象
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-16 09:58
 **/
public class Composite extends Component {
    /**
     * 用来存储组合对象中包含的子组件对象
     *
     * */
    private List<Component> childComponents = null;
    /**
     * 组合对象的名字
     * */
    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void addChild(Component child){
        //延迟初始化
        if (childComponents == null){
            childComponents = new ArrayList<Component>();
        }
        childComponents.add(child);
        //添加对父组件的引用
        child.setParent(this);

    }

    @Override
    public void removeChild(Component child) {
        if (childComponents != null){
            //查找到要删除的组件再集合中的索引位置
            int idx = childComponents.indexOf(child);
            if (idx != -1) {
                //先把背删除的商品类别对象的父商品类别
                //设置成为背删除的商品类别的子类别的父商品类别
                for (Component c :child.getChildren()){
                    //删除的组件对象事本实例的一个子组件对象
                    c.setParent(this);
                    //把被删除的撒谎给你篇类别对象的子组件对象添加到当前实例中
                    childComponents.add(c);
                }
                //真删除
                childComponents.remove(idx);

            }
        }
    }

    @Override
    public List<Component> getChildren(){
        return childComponents;
    }

    /**
     * 输出组合对象自身的结构
     *
     * */
    @Override
    public void printStruct(String preStr){
        //把自己输进去
        System.out.println(preStr +"+"+this.name);
        //如果包含有子组件，那么久输出这些组件对象
        if (this.childComponents !=null){
            //添加一个空额，表示向后缩进一个空格
            preStr+=" ";
            //输出当前对象的子对象
            for (Component c:childComponents){
                //递归输出对象的子对象
                c.printStruct(preStr);
            }
        }
    }
}
