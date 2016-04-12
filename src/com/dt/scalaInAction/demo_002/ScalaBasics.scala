package com.dt.scalaInAction.demo_002

import java.io.File

/**
 * Scala函数定义
 *      流程控制
 *      异常处理入门实战
 */
object ScalaBasics {
  /**
   * 无参函数
   */
  def doWhile() {
    var line = ""
    do {
      line = readLine()   //从控制台上读取一行输入的内容
      println("Read : " + line)
    } while (line != "")
  }
  
  
  
  /**
   * 由于object中的方法都是静态的 所以下面这段代码也可以执行 即时不在方法区内
   */
  /*  var line = ""
    do {
      line = readLine()   
      println("Read : " + line)
    } while (line != "")*/
  
      
      
  /**
   * 有参函数
   */
  def looper(x : Long, y: Long) : Long = {
    var a = x
    var b = y
    while (a != 0) {
      var temp = a
      a = b % a
      b = temp
    }
    b //返回时不需要写return
  }
  
  def main(args : Array[String]) : Unit = {
    
    var sss = "0001569DFE8A006828D4CEF3A2B4637FA72068FA8B866300569A562E9F2329B59D4E8E93322C558411E1C75FE06DF55206EC01303A111CA1BABEB305A4F3F58FBD0F1E5596F17C5025AC457D36BB556AC49373E5E02FCF6480D565D6951D1895B6CCBDFCF8A2A2330D32B19A88AE87FD";
    println(sss.length())
//    println("Hello World")    //注:可以没有";"
//    for(e <- args) println(e)
       
//    doWhile  //参数函数 可以省略括号调用
//    println("looper result : " + looper(2,4))
    
    /**
     * if 分支
     */
//    var file = "Scala.txt"
//    if (!args.isEmpty) file = args(0)
//    println("file : " + file)
    
    /**
     * 三目运算符
     */
//    val file = if(!args.isEmpty) args(0) else "site.xml"
//    println("file : " + file)
    //可以吧三目运算的结果看成一个值(表达式的值)
//    println((if(!args.isEmpty) args(0) else "site.xml"))
    
    /**
     * 循环
     */
    for(i <- 1 to 10) println("the number is " + i)
    println(1.to(10)); //--> Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    /**
     * 增强for
     */
//    val fs = (new File(".")).listFiles() //return  Array[File]
//    for(f <- fs) println(f)
    
    /**
     * 异常
     */
    val n = 99
    val file = "Spark.txt"
    //open the file
    try {
      val half = if(n % 2 == 0) n/2 else 
                 throw new RuntimeException("N must be even")
      
      //Use the file
    } catch {
      //异常的模式匹配
      case e: Exception => println("The exception is " + e.getMessage())
    }finally {
      //close the file
    }
    
  }
  
}