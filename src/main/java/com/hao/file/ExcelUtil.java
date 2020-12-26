package com.hao.file;

import com.github.ltsopensource.core.json.JSON;
import com.hao.demo.ListDemo;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-12-12 11:43
 **/
public class ExcelUtil {
    public static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {



    }

    public  void  method(){
        String file = "D:\\myFile\\week.csv";
        readCsvFile(file);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer mapKey = entry.getKey();
            List<Integer> mapValue = entry.getValue();
            System.out.println(mapKey + ":" + mapValue);
        }
    }

    public static void readCsvFile(String filePath) {
        try {
            //换成你的文件名
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            //第一行信息，为标题信息，不用,如果需要，注释掉
            reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                //CSV格式文件为逗号分隔符文件，这里根据逗号切分
                String item[] = line.split(",");
                //这就是你要的数据
                String last = item[item.length - 1];
                //如果是数值，可以转化为数值
                int value = Integer.parseInt(last);
                ListDemo listDemo = new ListDemo();
                listDemo.calcul(value);
                List<Integer> mathList = listDemo.res;
                List<Integer> list = new ArrayList<>(mathList);
                map.put(value, list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
