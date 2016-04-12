package com.dt.scalaInAction.demo_005

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

/**
 * Scala数组操作实战详解
 */
object ArrayOps {
  def main(args: Array[String]): Unit = {
    
     //定义长度为10的Int型数组(定长)
     val nums = new Array[Int](10) 
     //定义长度为10的String型数组
     val a = new Array[String](10) 
     //静态定义方式
     val s = Array("Hello", "World") 
     //修改数组中的值
     s(0) = "Goodbye"
     
     //for(e <- s) print(e+" ")
     
     /**
      * 定义 不定长 数组
      */
     val b = new ArrayBuffer[Int]();  //val b: ArrayBuffer[Int]
     //追加
     b += 1   //(1)
     //追加元祖
     b += (1, 2, 3, 5)  //1 1 2 3 5 
     //追加数组 ++=
     b ++= Array(8, 13, 21)   //1 1 2 3 5 8 13 21 
     //切除后5个元素
     b.trimEnd(5) //1 1 2 
     //切除前3个元素
     //b.trimStart(3) 
     
     //插入   def insert(n: Int, elems: Int*):Unit  在索引为n下插入
     b.insert(2, 6)  //1 1 6 2 
     //插入多值
     b.insert(2, 7, 8, 9)  //1 1 7 8 9 6 2 
     //删除指定下标对应的值
     b.remove(2) //1 1 8 9 6 2 
     //删除指定下标开始的n个元素   def remove(n: Int, count: Int): Unit
     b.remove(2, 3) //1 1 2    删除下标为2 3 4对应的值
     //可变的数组-->不可变数组  ArrayBuffer-->Array    此时不能采用 += 等操作了
     val c = b.toArray //val c: Array[Int]  
     
     //遍历
		 //for(e <- a) print(e+" ")  //null null null null null null null null null null 
     
     
     val d = Array(2, 3, 5, 7, 11)   //2 3 5 7 11
     // for yield  数组中每个元素乘以二
     val result = for (e <- d) yield 2 * e   //4 6 10 14 22 
     // for 中过滤筛选 
     val result2 = for (e <- d if e % 2 == 0) yield 2 * e  //4 
     // for 中过滤筛选  方式同上
     val result3 = d.filter(_ % 2 == 0).map(_ * 2)  //4
     //for(e <- result3) print(e+" ")  
     
     //求和  求最大值
     val sum = Array(1, 2, 3, 4, 5).sum  //15
     val sum1 = Array("Spark","Scala").max   //Spark
     val sum2 = Array(1, -1, 221).max   //Spark
     
     //排序
     val arr = Array(3, 7, 1, 9, 3)
     //sorted 操作不改变原来的数组
     val r = arr.sorted  //1 3 3 7 9 
     //快速排序  quickSort改变了原来的数组
     var r2 = scala.util.Sorting.quickSort(arr)  //1 3 3 7 9 
     
     val array = Array(1, 2, 3, 4, 5)   //1,2,3,4,5
     //连接 相当于JS数组中的join()方法    def mkString(sep: String): String
     val string = array.mkString(",")
     //def mkString(start: String, sep: String, end: String): String
     val string1 = array.mkString("(", "-", ")")  //(1-2-3-4-5)
     
     
     /**
      * 定义矩阵
      */
     val matrix = Array.ofDim[Int](3,4)   //val matrix: Array[Array[Int]]
     //赋值
     matrix(2)(1) = 42
     
     /**
      * 定义二维数组
      */
     val triangle = new Array[Array[Int]](10)
     for(index <- 0 until triangle.length){
         triangle(index) = new Array[Int](index + 1)
     }
     
  }
}