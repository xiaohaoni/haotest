package com.hao.demo.questions;

/**
 * 有n个楼梯，可以走1或者2步有几种走法
 *
 * @author zrh
 * @version 1.0
 * @date 2021-02-22 18:33
 **/
public class Staircase {
    public static void main(String[] args) {
        int i = Staircase.loop(11);
        System.out.println(Staircase.loop(11));
        //System.out.println(Staircase.foo(9));
    }
    public static  int  loop(int n){
        if (n ==1 || n==2){
            return n;
        }
        //走2步
        int one = 2;
        //走1步
        int two = 1;
        int sum = 0;
        for (int i = 3;i <= n;i++){
            sum = two+one;
            two = one;
            one = two;
        }
        return sum;
    }
    public static int foo(int n){
        if (n==2 || n == 1){
            return n;
        }
        return foo(n-2)+foo(n-1);
    }
}
