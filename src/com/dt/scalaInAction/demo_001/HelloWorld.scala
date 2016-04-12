package com.dt.scalaInAction.demo_001

/**
 * Scala开发环境搭建和HelloWorld解析
 */
object HelloWorld {
  /**
   * 
   * def 定义一个函数 这里的main为主程序的入口
   * main(args : Array[String])          函数名(参数名 : 参数类型 ...) : 函数返回类型
   * Unit 返回类型为空类型 相当于void
   * 
   */
  def main(args : Array[String]) : Unit = {
    println("Hello World");
    
    //遍历args数组中的值
    for(e <- args) println(e)
  }
  
}