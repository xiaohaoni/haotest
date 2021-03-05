package com.hao.demo;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-03-01 19:56
 **/
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

@Description(name = "substring_index",
        value = "substring_index(String a , String b,Integer index) ==> return res ",
        extended = "Example:\n"
                + " substring_index(\"0000--m--ctriphouse.ctrip.zero.20180730\",\"--\",-1) ==> \"ctriphouse.ctrip.zero.20180730\" \n"
                + " substring_index(\"0000--m--ctriphouse.ctrip.zero.20180730\",\"--\",1) ==> \"0000\";"
)
public class SubStringIndexUDF extends UDF {

    public String evaluate(String str, String reg, Integer index){
        if (str == null || reg == null || index == 0) {
            return null;
        }
        String res = null;
        try{
            String[] temp = str.split(reg);
            //如果 index为正数,从前取n个字符,若为负数,从后去n个字符
            if (index > 0) {
                for (int i = 0; i <= index-1; i++) {
                    if (res == null) {
                        res = temp[i];
                    } else {
                        res = res + reg + temp[i];
                    }
                }
            } else {
                for (int i = temp.length - 1; i > temp.length -1+ index; i--) {
                    if (res == null) {
                        res = temp[i];
                    } else {
                        res = temp[i] + reg + res;
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        SubStringIndexUDF s = new SubStringIndexUDF();
        String evaluate = s.evaluate("0000--m--ctriphouse.ctrip.zero.20180730","--",0);
        String evaluate1 = s.evaluate("0000--ctriphouse.ctrip.zero.20180730","--",-1);
        String evaluate2 = s.evaluate("0000","--",-1);
        System.out.println(evaluate);
        System.out.println(evaluate1);
    }
}
