package com.dt.scalaInAction.demo_028

/**
 * Scala提取器Extractor实战详解
 */
object ExtractorOps {
    def main(args: Array[String]): Unit = {
        
        def match_array(arr: Any) = arr match {
            case Array(0) => println("Array" + "0")
            case Array(x, y) => println("Array" + x + " " + y)  //匹配有两个元素的数组
            case Array(0, _*) => println("Array" + "0 ...")     //匹配至少是1个元素，并且第一个元素为0的数组  _*表示后面有许多元素
            case _ => println("something else")
        }
        match_array(Array(0))                    //Array0
        match_array(Array(0, 1))                 //Array0 1
        match_array(Array(0, 1, 2, 3, 4, 5, 6))  //Array0 ...

        //正则表达式匹配
        val pattern = "([0-9]+) ([a-z]+)".r
        "20150626 hadoop"  match {
          case pattern(num, item) => println(num + ":" + item)   //20150626:hadoop
        }
        
    }
}