package com.zhl.practice.referenceTest;

import com.zhl.practice.MySon;

import java.lang.ref.WeakReference;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-09-11 10:58
 **/
public class WeakReferenceTest {

    public static void main(String[] args) {
        // 强引用
//        MySon mySon = new MySon(1,"zhl","男");
        // 弱引用
//        WeakReference<MySon> mySonWeakReference = new WeakReference<>(mySon);
        // 如果弱引用指向的对象还有其它地方引用，则GC之后,该弱引用不会被回收
//        mySon = null;
        // 输出值： zhl
//        System.out.println("引用类型,GC之前：" + mySonWeakReference.get().getName());
//        System.gc();
//        System.runFinalization();
        // 不设置mySon = null之后输出值：zhl   显示设置mySon = null之后报空指针异常,表示已被回收
//        System.out.println("引用类型,GC之后：" + mySonWeakReference.get().getName());

        // 验证字符串缓存池对弱引用的影响
//        String name = "奥特曼";
//        // 弱引用
//        WeakReference<String> stringWeakReference = new WeakReference<>(name);
//        name = null;
//        // 输出值：奥特曼
//        System.out.println("字符串常量类型,GC之前：" + stringWeakReference.get());
//        System.gc();
//        System.runFinalization();
//        // 输出值：奥特曼  为什么此处不管设置不设置name=null,name对象都没有被回收呢。原因是执行String name = "奥特曼"时,
//        // 会直接在缓存池中创建一个常量“奥特曼”，然后将name指向该常量的地址。GC回收时,不会回收缓存池中的内存空间。
//        System.out.println("字符串常量类型,GC之后：" + stringWeakReference.get());

        // 验证上述缓存池会对弱引用产生影响的结论
        String nameObjct = new String("奥特曼");
//        nameObjct = nameObjct.intern(); 执行此代码会将"奥特曼"放入常量池中,并将nameObjct的引用指向该常量池对象。此时下面两行代码输出的都是“奥特曼”
        // 弱引用
        WeakReference<String> stringObjectWeakReference = new WeakReference<>(nameObjct);
        nameObjct = null;
        // 输出值：奥特曼
        System.out.println("字符串引用类型,GC之前：" + stringObjectWeakReference.get());
        System.gc();
        System.runFinalization();
        // 输出值：null
        System.out.println("字符串引用类型,GC之后：" + stringObjectWeakReference.get());

    }

}
