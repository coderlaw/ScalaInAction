package com.dt.scalaInAction.demo_052

/**
 * Scala中路径依赖代码实战详解
 */
class Outer {
    private val x = 10
    class Inner {
        private val y = x + 10
    }
}

object Path_Dependence {
    def main(args: Array[String]): Unit = {
        val outer = new Outer
        val iner = new outer.Inner  //val iner: outer.Inner
        /**
         * Scala中的内部类 必须依赖于外部类的实例 而外部类的实例各不相同 所以被之为这种对于外部类的依赖为"路径依赖"
         * 所以不同的路劲代表不同的类型
         */
        val inner2: outer.Inner = new outer.Inner
        
        val o1 = new Outer
        val o2 = new Outer
        
        //val i: o2.Inner = new o1.Inner  //error  
        //这说明o2.Inner 和 o1.Inner不是同一个类型 根本原因是因为o1和o2类型不用 导致"路径"不同
        
        //这说明o1.Inner是Outer#Inner的子类 这种方式称之为"类型投影" 在实战中作用不大
        val i: Outer#Inner = new o1.Inner 
        val j: Outer#Inner = new o2.Inner //说明o1.Inner和o2.Inner都有共同的子类Outer#Inner
    }
}