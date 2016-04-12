package com.dt.scalaInAction.demo_059

import scala.io.Source
import java.io.File

/**
 * Scala中隐式转换初体验实战详解以及隐式转换在Spark中的应用源码解析
 */
//这里的RichFile相当于File的增强类 需要的将要增强的类作为参数传入构造器中
class RichFile(val file: File) {
  def read = {
      Source.fromFile(file.getPath).mkString
  }
}

object Context {
    //File --> RichFile
    //implicit是隐式转换的关键字 这里定义一个隐式转换函数把当前类型转换成增强的类型
    implicit def file2RichFile(file: File) = new RichFile(file)
}

object Hello_Implicit_Conversions {
    def main(args: Array[String]): Unit = {
        import Context.file2RichFile
        //File类本身没有read方法 通过隐式转换完成
        //这里的read方法是RichFile类中的方法  需要通过隐式转换File --> RichFile
        println(new File("E:\\projectTest\\1.txt").read)
      
    }
}