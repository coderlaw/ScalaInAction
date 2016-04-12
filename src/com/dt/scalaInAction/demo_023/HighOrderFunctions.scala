package com.dt.scalaInAction.demo_023

/**
 * Scala高阶函数实战详解
 */
object HighOrderFunctions {
    def main(args: Array[String]): Unit = {
        //1 打印阶梯状的*号
//        1.to(9).map("*" * _).foreach(println)
      
        //2 过滤1~9中的偶数
//        1.to(9).filter(_ % 2 == 0).foreach(println _)  //row result: 2 4 6 8
        
        //3 9*8*7*6*...*1
//        println((1 to 9).reduceLeft(_ * _))  
      
        //4 按单词的长度升序排列
        /*
        "Spark is the most exciting thing happening in big data today"
             .split(" ")
             .sortWith(_.length < _.length)
             .foreach(println)
        */
      
        //5
        /*
        val fun = ceil _
        val num = 3.14
        fun(num)
        Array(3.14, 1.42, 2.0).map(fun)
        */
      
        //6
//        val triple = (x: Double) => 3 * x
//        Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x).foreach(println)    //row result: 9.42 4.26 6.0
//        Array(3.14, 1.42, 2.0).map{  (x: Double) => 3 * x }.foreach(println) //row result: 9.42 4.26 6.0
        
        //7 高阶函数标准的定义方式   f: (Double) => Double   函数作为的参数类型定义  (参数值类型...) => 返回值类型
        def high_order_functions(f: (Double) => Double) = f(0.25)
//        println(high_order_functions(ceil _))
//        println(high_order_functions(sqrt _))
      
        //8   (x: Double)才是正真执行所要传入的参数
        def mulBy(factor: Double) = (x: Double) => factor * x
        val quintuple = mulBy(5)
        println(quintuple(20))   //执行时 x=20     row result: 100.0
        
        
        //9 高阶函数的简化写法推导
        println(high_order_functions((x: Double) => 3 * x))   //row result: 0.75
        high_order_functions((x) => 3 * x )
        high_order_functions(x => 3 * x )
        high_order_functions(3 * _)
        
        val fun2 = 3 * (_: Double)
        val funn3:(Double) => Double = 3 * _   //_为返回类型(Double) => Double中的参数类型
    }
}