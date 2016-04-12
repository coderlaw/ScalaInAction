package com.dt.scalaInAction.demo_018

import scala.io.Source
import java.io.File
import java.io.PrintWriter

/**
 * Scala中文件的读取、写入、控制台输入操作代码实战
 */
object FileOps {
    def main(args: Array[String]): Unit = {
        //读取本地文件
//        val file = Source.fromFile("E:\\projectTest\\1.txt")  //返回 BufferedSource(文件迭代器)
//        for(line <- file.getLines) println(line)  //def getLines(): Iterator[String]
//        file.close
        
        //读取网络文件
//        val webFile = Source.fromURL("http://spark.apache.org/")
//        webFile.foreach(print(_))
//        webFile.close
      
        //写入文件
//      val writer = new PrintWriter(new File("scalaFile.txt"))
//      for(i <- 1 to 100) writer.println(i)
//      writer.close
      
      //控制台输入
      println("Please enter your input:")
      val line = Console.readLine
      println("Thanks you just type : " + line )
      
    }
}