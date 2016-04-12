package com.dt.scalaInAction.demo_003

import scala.io.Source

/**
 * 文件操作
 */
object FileOps {
    def main(args: Array[String]): Unit = {
        //val file = Source.fromFile("E:\\projectTest\\1.txt")  //返回类型为 BufferedSource
        val file = Source.fromURL("http://spark.apache.org/")  //抓取网络信息
        var lines = file.getLines  //var lines : Iterator[String]
        for(line <- lines) println(line) 
    }
}