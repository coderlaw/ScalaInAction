package com.dt.scalaInAction.demo_025

/**
 * Scala中Curring实战详解
 * Curring:颗粒化
 */
object Curring {
    def main(args: Array[String]): Unit = {
        //1
        def multiple(x: Int, y: Int) = x * y
        def multipleOne(x: Int) = (y: Int) => x * y
        println(multipleOne(6)(7))           //x->6 y->7   row result: 42
        
        def curring(x: Int)(y: Int) = x*y
        println(curring(10)(10))
        
        val a = Array("Hello", "Spark")
        val b = Array("hello", "spark")      //x->6 y->7   row result: 42100
        println(a.corresponds(b)(_.equalsIgnoreCase(_)))  //row result:  true
        
    }
}