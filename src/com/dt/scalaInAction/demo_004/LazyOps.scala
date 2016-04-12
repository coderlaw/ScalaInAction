package com.dt.scalaInAction.demo_004

import scala.io.Source

/**
 * Lazy 延时加载
 */
object LazyOps {
    def main(args: Array[String]): Unit = {
//      val f = Source.fromFile("E:\\1.txt"); //由于路径不存在 导致异常 证明变量在定以后就会加载
      lazy val file = Source.fromFile("E:\\1.txt"); //lazy关键字 声明的变量只有在变量第一次使用的时候才会加载  证明是延时加载
      print("go")
    }
}