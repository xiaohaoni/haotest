package com.hao.config.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-01-11 17:46
 **/
public class AsciiString {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        char c = '3';
        if (c < 48 || c > 57) {
            System.out.println(c);
        } else {
            System.out.println(c);
        }
        //  toInfixExpressionList(expression);
    }

    //方法：将 中缀表达式转成对应的List
    //  s="1+((2+3)×4)-5";
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            c = s.charAt(i);
            System.out.println(c);
            //如果c是一个非数字，我需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //i需要后移
            } else { //如果是一个数，需要考虑多位数
                str = ""; //先将str 置成"" '0'[48]->'9'[57]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;//返回
    }

}
