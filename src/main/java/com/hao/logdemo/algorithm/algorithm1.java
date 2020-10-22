package com.hao.logdemo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断str1是否包含str2，包含就返回第一次包含的位置
 *分治算法
 * 回溯算法 八皇宫算法
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-15 15:29
 **/
public class algorithm1 {

    static void kmpAlgorithm() {
        String str = "wo shi zhu ren hao";
        String  str2 = str.replaceAll("shi","是");
        System.out.println(str2);

    }
    

    static List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int[] maxMatchLengths = calculateMaxMatchLengths(pattern);
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            while (count > 0 && pattern.charAt(count) != text.charAt(i)) {
                count = maxMatchLengths[count - 1];
            }
            if (pattern.charAt(count) == text.charAt(i)) {
                count++;
            }
            if (count == pattern.length()) {
                positions.add(i - pattern.length() + 1);
                count = maxMatchLengths[count - 1];
            }
        }
        return positions;
    }

    public static void main(String[] args) {
        kmpAlgorithm();
    }

    // 构造模式串 pattern 的最大匹配数表
    static int[] calculateMaxMatchLengths(String pattern) {
        int[] maxMatchLengths = new int[pattern.length()];
        System.out.println(maxMatchLengths);
        int maxLength = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
                maxLength = maxMatchLengths[maxLength - 1]; // ①
            }
            if (pattern.charAt(maxLength) == pattern.charAt(i)) {
                maxLength++; // ②
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }
}
