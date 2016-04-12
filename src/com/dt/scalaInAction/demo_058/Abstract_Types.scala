package com.dt.scalaInAction.demo_058

import scala.io.BufferedSource
import scala.io.Source

/**
 * Scala中Abstract Types实战详解
 */
trait Reader {
    /**
     * 用type关键字 声明一个In类型(称为"抽象类型") 
     * 但没有指明具体类型是什么类型  需要在它的实现类中指明具体的类型
     * 
     * 在声明抽象类型时 可以对类型进行限定
     */
    type In <: java.io.Serializable
    type Contents
    /**
     * 在抽象对的可以使用抽象类型
     */
    def read(in: In): Contents
}
class FileReader extends Reader {
    type In = String //在实现中赋值具体的类型
    type Contents = BufferedSource  //type Contents = Contents
    def read(name: In) = {
        Source.fromFile(name)
    } 
}
object Abstract_Types {
    def main(args: Array[String]): Unit = {
        val fileReader = new FileReader
        val content = fileReader.read("E:\\projectTest\\1.txt")
        for (line <- content.getLines) println(line)
    }
}