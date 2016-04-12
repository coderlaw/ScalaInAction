package com.dt.scalaInAction.demo_065

import java.io.File
import scala.io.Source

/**
 * Scala中隐式转换内幕操作规则揭秘、最佳实践及其在Spark中的应用源码解析
 */
class RichFile(val file: File) {
    def read = Source.fromFile(file.getPath).mkString
}
class File_Impkicits(path: String) extends File(path)
object File_Impkicits {
    implicit def file2RichFile(file: File) = new RichFile(file) //file-->RichFile
}

object Implicits_Internals {
    def main(args: Array[String]): Unit = {
       /*
        * 这里没有导入隐式对象
        * 
        * 通过给File_Impkicits类 构建一个伴生对象 在伴生对象内部顶一个隐式转换的方法
        * 
        * 执行顺序:
        * 1.搜索File_Impkicits有无read方法 
        * 2.在上下文上搜索(有无导入的隐式对象)
        * 3.搜索File_Impkicits的伴生对象内有无隐式转换  发现implicit关键 尝试匹配类型  
        *    例如这里匹配file2RichFile(file: File) 返回类型为RichFile 在RichFile中发现read方法
        */
       println(new File_Impkicits("E:\\projectTest\\1.txt").read)
    }
}