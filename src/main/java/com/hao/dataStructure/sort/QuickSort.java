package com.hao.dataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序
 *
 * @author zrh
 * @version 1.0
 * @date 2021-01-25 10:15
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
       /* int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }*/

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    /**
     * 思想：将数组分为一大一小两部分
     * 如何分：取一个数，将比这个数大的放在右边，比这个数小的放在左边，
     * 然后再按此方法分别进行快速排序
     * 用递归实现
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //中轴值
        int pivot = arr[(left + right) / 2];
        //临时变量
        int temp = 0;
        //比pivot大放在右边,小的放在左边
        while (l < r) {

            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }

            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }

            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    //从小到打排序
    private void quickSort1(int arr[], int left, int right) {
        int l = left;
        int r = right;
        int pilot = arr[(l + r) / 2];
        int temp=0;
        while (l < r) {
            //有左边大于中间值的就跳出
            while (arr[l] > arr[pilot]) {
                l++;
            }
            //有右边小于中间值的就跳出
            while (arr[r] < arr[pilot]) {
                r++;
            }
            //已经分配完成
            if (l >= r) {
                break;
            }

            //交换值
            temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pilot) {
                r -= 1;
            }

            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pilot) {
                l += 1;
            }
        }
        if (l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if (left < r) {
            quickSort1(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort1(arr, l, right);
        }
    }
}
