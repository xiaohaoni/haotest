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
