package com.dt.scalaInAction.demo_022

/**
 * Scala中的闭包实战详解
 */
object ClosureOps {
    def main(args: Array[String]): Unit = {
        //e.g 1
        val data = List(1, 2, 3, 4, 5, 6)
        var sum = 0
        data.foreach(sum += _)
        println(sum)            //row result: 21
        
        
        //e.g 2
        def add(more: Int) = (x: Int) => x + more
        val a = add(1)          //等价于 def a(x:Int) = x + 1
        val b = add(9999)       //等价于 def b(x:Int) = x + 9999
        println(a(10))          //row result: 11
        println(b(10))          //row result: 10009
    }
}