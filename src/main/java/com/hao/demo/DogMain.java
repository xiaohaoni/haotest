package com.hao.demo;

import java.util.regex.Pattern;

/**
 * 实现类
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 10:12
 **/
public class DogMain {

    public static void main(String[] args) {


    }

    /**
     * 车牌号验证
     */
    static boolean checkPlateNumberFormat(String content) {
        String pattern = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
        return Pattern.matches(pattern, content);
    }


    private void getDogObj(Integer i) {
        i += 4;
    }
}
