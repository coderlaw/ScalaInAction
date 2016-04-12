package com.dt.scalaInAction.demo_020

import scala.io.Source

/**
 * Scala中的本地函数与作为语言一等公民的函数详解
 */
object FunctionOps {
    def main(args: Array[String]): Unit = {
        
        val width = args(0).toInt
        for(arg <- args.drop(1))
            processData(arg, width)
        
        
      
        
        /**
         * 函数是有值的 函数可以赋值给变量
         * (x: Int) => x+1   (x: Int)是匿名的  "=>"为函数的实现
         */
        var increase = (x: Int) => x+1
        println(increase(5))     //row result: 6
        //变量可以接受 其他函数值
        increase = (x: Int) => x*2
        println(increase(5))     //row result: 10
        println("-----------------------------------") 
        
        
        val someNumbers = List(-11, -10, -5, 0, 5, 10)
        someNumbers.foreach( (x: Int) => print(x + "\t") )  //row result:-11 -10 5 0 5 10
        println()
        someNumbers.filter( (x: Int) => x > 0 ).foreach( (x: Int) => print(x + "\t") )  //row result:5 10
        println()
        someNumbers.filter( (x) => x > 0 ).foreach( (x: Int) => print(x + "\t") )       //row result:5 10
        println()
        someNumbers.filter( x => x > 0).foreach( (x: Int) => print(x + "\t") )          //row result:5 10
        println()   
        someNumbers.filter( _ > 0 ).foreach( (x: Int) => print(x + "\t") )              //row result:5 10
        val f = (_: Int) + (_: Int)
        println()
        println(f(5, 10))     //row result: 15 
    }
    
    /**
     * 本地函数  line20-23
     * (1) 本地函数所在的函数的外界不可以访问本地函数
     * (2) 本地函数可以访问 所在函数传进来的参数  
     * 
     * Scala中允许在函数中定义函数  定义的函数在私有函数 外界不可以访问   这样的函数被称之为"本地函数"也成为"内部函数"
     * 这样的做理由是因为 函数在Scala中是一等公明  函数可以看成变量一样 可以赋值
     */
    def processData(filename: String, width: Int) {
        //该函数为processData的私有函数 外部不可以访问  
        def processLine(line: String) {
            if (line.length > width)
              println(filename + ": " + line)
        }
        
        val source = Source.fromFile(filename)
        for(line <- source.getLines) 
          processLine(line)
    }
}