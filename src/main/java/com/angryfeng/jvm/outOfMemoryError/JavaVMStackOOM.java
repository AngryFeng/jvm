package com.angryfeng.jvm.outOfMemoryError;

/**
 * @ClassName: JavaVMStackOOM
 * @Description: JavaVMStackOOM
 * @author: angryfeng
 * @date: 2018-11-14
 * @version: V1.0
 * VM Args：-Xss2M
 */
public class JavaVMStackOOM {
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                while (true) {}
            });
            thread.start();
        }
    }
    
    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }
}
