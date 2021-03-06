package com.angryfeng.jvm.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName: FinalizeEscapeGC
 * @Description: TODO 一句话描述该类
 * @author: angryfeng
 * @date: 2018-11-15
 * @version: V1.0
 * 1.对象可以在被GC时自我拯救
 * 2.这种自救机会只有一次，因为一个对象的finalize()方法最多只会被系统调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    
    public void isAlive() {
        System.out.println("I am still alive");
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("I am saving myself");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
    
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead");
        }
    
        //下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }
    
    public static String processFile() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }
}
