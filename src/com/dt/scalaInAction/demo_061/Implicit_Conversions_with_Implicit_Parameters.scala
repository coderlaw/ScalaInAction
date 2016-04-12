package com.dt.scalaInAction.demo_061

/**
 * Scala中隐式参数与隐式转换的联合使用实战详解及其在Spark中的应用源码解析
 */
object Implicit_Conversions_with_Implicit_Parameters {
  
    def main(args: Array[String]): Unit = {
        
        /**
         * (1)bigger[T]为泛型函数
         * (2)bigger(...)(...)该函数是颗粒化的
         * (3)第二个括号传入的是一个函数 类型为T => Ordered[T] orders是隐式参数 输入类型为T类型， 返回类型为Ordered[T]类型
         * 
         * */
        def bigger[T](a: T, b: T)(implicit ordered: T => Ordered[T]) = {
            /**
             * ordered(a) > b中的">"是一个函数 具体定义在Ordered类中 
             * Source define:
             *        def >  (that: A): Boolean = (this compare that) >  0
             */
            if (ordered(a) > b) a else b   // if (a > b) a else b  这样写也可以
        }
      
        println(bigger(4, 3))                 //4
        println(bigger("Spark", "Hadoop"))    //Spark
        
    }
}