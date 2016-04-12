package com.dt.scalaInAction.demo_063

import scala.io.Source
import java.io.File

/**
 * Scala中隐式类代码实战详解
 */
object Context_Helper {
    implicit class FileEnhancer(file: File) {
        def read = Source.fromFile(file.getPath).mkString
    }
    implicit class Op(x: Int) {
        def add(second: Int) = x + second
    }
}

object Implicits_Class {
  
    def main(args: Array[String]): Unit = {
        import Context_Helper._
        println(1.add(2))    //3
        
        /**
         * File对象中并没有read方法 编译器会在全局范围内查询匹配的隐式类
         * 在Context_Helper导入的类中有FileEnhancer 接受File类型的类 会自动匹配 、
         * 使得File对象通过这种隐式的方法具有read方法
         */
        println(new File("E:\\projectTest\\1.txt").read)   
    }
}