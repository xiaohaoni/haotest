package com.hao.dataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 推排序
 *
 * @author zrh
 * @version 1.0
 * @date 2021-01-28 14:37
 **/
public class HeapSort {

    public static void main(String[] args) {
        //要求将数组进行升序排序
        int arr[] = {4, 6, 8, 5, 9};
        // 创建要给80000个的随机的数组
        /*int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            // 生成一个[0, 8000000) 数
            arr[i] = (int) (Math.random() * 10);
        }*/

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        //System.out.println("排序后=" + Arrays.toString(arr));
    }


    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序!!");
        // arr.length / 2 - 1 得到最后一个有孩子节点的节点
        /**
         * 需要先将数组成为大顶堆，然后再进行排序
         * */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        /*
		 * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
　　			3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
		 */
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }

    //将一个数组(二叉树), 调整成一个大顶堆

    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param lenght 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int arr[], int i, int lenght) {
        //中间转换的数
        int temp = arr[i];
        /**
         * 数组索引值，
         * k:第i个数的左子节点，
         * */
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            //i的左子节点是否小于右子节点
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap01(int[] arr, int i, int length) {
        int temp = arr[i];
        /**
         * 找到i的左孩子节点
         * */
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > arr[i]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;

    }
}
