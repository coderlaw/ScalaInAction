package com.dt.scalaInAction.demo_021

/**
 * Scala中的偏函数实战详解
 */
object PartialAppliedFunction {
    def main(args: Array[String]): Unit = {
        val data = List(1, 2, 3, 4, 5, 6)
        /**
         *  foreach实现
         *  @inline override final
         *  def foreach[B](f: A => B) {
         *    var these = this
         *    while (!these.isEmpty) {
         *       f(these.head)
         *       these = these.tail
         *     }
         *   }
         */
       // data.foreach(println _)        //这里的_表示集合中所有的参数列表 row result: 1 2 3 4 5 6
       // data.foreach(x => println(x))  //row result: 1 2 3 4 5 6
        
        
        def sum(a: Int, b: Int, c: Int) = a + b + c
        println(sum(1, 3, 4))   //row result: 8
        
        val fp_a = sum _  //_表示所有的参数列表    val fp_a: (Int, Int, Int) => Int
        println(fp_a(1, 2, 3))  //row result: 6
        println(fp_a.apply(1, 2, 3))   //row result: 6
        
        val fp_b = sum(1, _: Int,  3)  //可以传递其中部分值 单必须声明类型
        println(fp_b(2))       //row result: 6
        println(fp_b(10))      //row result: 14
        
        data.foreach(println _)
        data.foreach(println)
        
    }
}