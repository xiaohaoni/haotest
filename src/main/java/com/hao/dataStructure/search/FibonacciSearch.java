package com.hao.dataStructure.search;

import java.util.Arrays;

/**
 * 斐波拉契算法
 * 黄金分割法
 *
 * @author zrh
 * @version 1.0
 * @date 2021-01-23 15:30
 **/
public class FibonacciSearch {
    private static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        int[] f = fib();
        System.out.println(Arrays.toString(f));
        /*int[] arr = {1, 8, 10, 89, 1000, 1234};
        // 0
        System.out.println("index=" + fibSearch(arr, 89));*/
    }


    /**
     * 先获取斐波拉契数列
     * 因为后面我们mid=low+F(k-1)-1，需要使用到斐波那契数列，
     * 因此我们需要先获取到一个斐波那契数列
     * <p>
     * f[i]=f[i-1]+f[i-2];
     */
    public static int[] fib() {
        int[] f = new int[MAX_SIZE];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MAX_SIZE; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 编写斐波那契查找算法
     * 使用非递归的方式编写算法
     * 列 F[k]=F[k-1]+F[k-2]
     *
     * @param a   数组
     * @param key 我们需要查找的关键码(值)
     * @return 返回对应的下标，如果没有-1
     */
    public static int fibSearch(int[] a, int key) {
        //起始位数
        int low = 0;
        //最后一位数
        int high = a.length - 1;
        //表示斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        //获取斐波那契数列
        int f[] = fib();
        //获取到斐波那契分割数值
        while (high > f[k]) {
            k++;
        }

        //因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需求使用a数组最后的数填充temp
        //实际上需求使用a数组最后的数填充 temp
        //举例:
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for (int i = high + 1; i < temp.length - 1; i++) {
            temp[i] = a[high];
        }
        //使用while来循环处理，找到我们的数key，找中间数
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            //我们应该继续向数组的前面查找(左边)
            if (key < temp[mid]) {
                high = mid - 1;
                //为甚是 k--
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即 在 f[k-1] 的前面继续查找 k--
                //即下次循环 mid = f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                //为什么是k -=2
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //3. 因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //4. 即在f[k-2] 的前面进行查找 k -=2
                //5. 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else { //找到
                //需要确定，返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
