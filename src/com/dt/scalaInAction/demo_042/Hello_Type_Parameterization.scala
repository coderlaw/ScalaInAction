package com.dt.scalaInAction.demo_042

import scala.reflect.ClassTag

/**
 * 定义一个泛型类 []中定义的就是未知的类型 只有赋值使用时才能确定具体的类型
 */
class Triple[X: ClassTag, Y, Z](val first: X, val second: Y, val thrid: Z)

/**
 * Scala中泛型类、泛型函数、泛型在Spark中的广泛应用
 */
object Hello_Type_Parameterization {
    def main(args: Array[String]): Unit = {
        //在定义后scala的类型推断会得出triple类型为 Triple[String, Int, Double]
        val triple = new Triple("Spark", 3, 3.1415926)
        //显示声明类型
        val bigData = new Triple[String, String, Char]("Spark", "Hadoop", 'R')
    
    
        //定义泛型函数
        def getData[T](list: List[T]) = list(list.length / 2)
        println(getData(List("Spark", "Hadoop", 'R')))  //Hadoop

        val f = getData[Int] _  //显式指定类型    //val f: List[Int] => Int
        println(f(List(1,2,3,4,5,6,7,8))) //5
        
        
        def foo[A, B](f: A => List[A], b: A) = f(b)
    }
}