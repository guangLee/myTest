package com.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtil {

    private static Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
    /**
     * 去掉字符串中的括号以及括号中的内容 demo： 庆丰包子(前门店)  调用后：庆丰包子
     * @param str
     * @return
     */
    public static String deleteBracket(String str) {

        int head = str.indexOf('(');
        int tail = str.indexOf(')');
        String str2 = str.substring(head, tail + 1);
        String strReturn = str.replace(str2, "");
        return strReturn;
    }

    /**
     * 调用ORC接口之前，如果图片url中有中文，要先进行转码，然后才能成功调用OCR
     * @param url
     * @return
     */
    public static String changeCode(String url) {

        StringBuffer sb = new StringBuffer();
        try {
            url = URLEncoder.encode(url, "UTF-8");
            String[] strArr = url.split("%2F");

            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = URLEncoder.encode(strArr[i], "UTF-8");
            }
            for (int i = 0; i < strArr.length; i++) {
                if (i == strArr.length - 1) {
                    sb.append(strArr[i]);
                } else {
                    sb.append(strArr[i] + "%2f");
                }
            }
        } catch (Exception e) {
        }
        return sb.toString();
    }

    /**
     * 判断字符串是否是中文
     * @param str
     * @return
     */
    public static boolean hasChinese(String str) {
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 一个有算法含量的分割字符串方法，能实现这个代码的人，脑子不算笨
     * @param str
     * @return
     */
    public static List<String> getStrArray(String str){
        List<String> strArr = new ArrayList<String>();
        int j= str.length();
        int temp = j;
        for(int i=0;i<j-1;i++){
            int t= temp;
            StringBuffer sb = new StringBuffer();
            for(int k =0;k<i+1;k++){
                sb.append(str.substring(k,t)+" ");
                t++;
            }
            strArr.add(sb.toString());
            temp--;
        }
        return strArr;
    }
}
