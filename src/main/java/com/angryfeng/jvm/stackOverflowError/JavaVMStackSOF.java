package com.angryfeng.jvm.stackOverflowError;

/**
 * @ClassName: JavaVMStackSOF
 * @Description: Java虚拟机栈溢出
 * @author: angryfeng
 * @date: 2018-11-14
 * @version: V1.0
 * -Xss 设置每个线程的堆栈大小
 * VM args: -Xss108K
 */
public class JavaVMStackSOF {
    int stackLength = 0;
    
    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
       try {
           javaVMStackSOF.stackLeak();
       } catch (Throwable t) {
           System.out.println("stack length: " + javaVMStackSOF.stackLength);
           t.printStackTrace();
       }
    }
    
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
