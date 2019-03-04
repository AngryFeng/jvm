package com.angryfeng.jvm.stringTest;

/**
 * @ClassName: StringTest
 * @Description: TODO 一句话描述该类
 * @author: angryfeng
 * @date: 2018-11-14
 * @version: V1.0
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
    
        String str2 = "java";
        System.out.println(str2.intern() == str2);
    }
}
