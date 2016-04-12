package com.dt.scalaInAction.demo_009

class Outer (val name : String) {  outer =>  //定义外部类名称 用于内部类调用
    class Inner(val name : String) {
        def foo(b : Inner) {
            println("Outer:"+outer.name+" Inner:"+b.name)
        }
    }
}

/**
 * Scala的内部类实战详解
 * 
 * Scala的在内部类 和Java的内部类有很大不同
 *      Java中的内部类是从属于外部类的
 *      Scala中的内部类是从属于对象的    new出外部类对象 的每一个内部类都是不同的(内部类隶属于外部类的实例本身)
 */
object OOPInnerClass {
    def main(args: Array[String]): Unit = {
        val outer1 = new Outer("Spark")
        val outer2 = new Outer("Hadoop")
        
        /**
         * 内部类的方式和Java不同 Java是 outer1.new Inner()
         */
        val inner1 = new outer1.Inner("Scala");
        val inner2 =  new outer2.Inner("Java");
        
        inner1.foo(inner1)
        inner2.foo(inner2)
        
        //inner1.foo(inner2)  //错误 但在Java中是可行的
    }
}