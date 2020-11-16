package com.hao.mode.combination;

/**
 * 叶子对象
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-16 09:51
 **/
public class Leaf extends Component {
    /**
     * 叶子对象的名字
     */
    private String name = "";

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + ""+name);
    }
}
