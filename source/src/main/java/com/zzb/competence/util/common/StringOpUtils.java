package com.zzb.competence.util.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guanzhenxing on 2014-08-08.
 */
public class StringOpUtils {

    /**
     * 数据库转义字符处理
     * @param str
     * @param escape
     * @return 替换后的字符
     */
    public static String escapeStr(String str,String escape){
        str = str.replace("_",escape+"_");
        str = str.replace("%",escape+"%");
        return str;
    }

    /**
     * 将string转为Long list
     * @param str
     * @param split
     * @return list
     */
    public static List StrToLongList(String str, String split){
        final String [] arr = str.split(split);
        List result = new ArrayList<Long>(){
            {
                for(String id : arr){
                    add(Long.valueOf(id));
                }
            }
        };
        return result;
    }

    /**
     *  将string转为 list
     * @param str
     * @param split
     * @return list
     */
    public static List StrToList(String str, String split){
        return Arrays.asList(str.split(split));
    }
}
