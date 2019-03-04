package com.angryfeng.jvm.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HeapOOM
 * @Description: 堆溢出
 * @author: angryfeng
 * @date: 2018-11-14
 * @version: V1.0
 * 堆的最小值-Xms参数,最大值-Xmx参数,-xx:+HeapDumOnOutOfMemoryError让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照
 * VM args: -xmx10m -xms5m -xx:+HeapDumOnOutOfMemoryError
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<HeapOOM> arrs = new ArrayList<>();
        while (true) {
            System.out.println(arrs.size());
            arrs.add(new HeapOOM());
        }
    }
}
