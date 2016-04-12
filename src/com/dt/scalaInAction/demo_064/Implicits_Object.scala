package com.dt.scalaInAction.demo_064

/**
 * Scala中隐式对象代码实战详解
 */
abstract class Template[A] {
    def add(x: A, y: A): A
}
abstract class SubTemplate[A] extends Template[A] {
    def unit: A
}
object Implicits_Object {
    def main(args: Array[String]): Unit = {
        implicit object StringAdd extends  SubTemplate[String] {
            def add(x: String, y: String): String = x concat y
            def unit: String = ""
        }  
        
        //定义隐式对象  定义方式:implicit object XXX
        implicit object IntAdd extends SubTemplate[Int] {
            def add(x: Int, y: Int): Int = x + y
            def unit: Int = 0
        } 
        
        //implicit m: SubTemplate[T]中 m是一个隐式对象
        def sum[T](xs: List[T])(implicit m: SubTemplate[T]): T =
            if (xs.isEmpty) m.unit 
            else m.add(xs.head, sum(xs.tail))
            
        println(sum(List(1, 2, 3)))         //6
        println(sum(List("Scala", "Spark", "Kafka")))   //ScalaSparkKafka
      
    }
}