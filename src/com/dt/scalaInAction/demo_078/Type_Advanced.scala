package com.dt.scalaInAction.demo_078
import scala.reflect.runtime.universe._
/**
 * Type与Class实战详解
 */
class Spark
trait Hadoop
object Flink
class Java {
    class Scala
}
object Type_Advanced {
    def main(args: Array[String]): Unit = {
        println(typeOf[Spark])   //com.dt.scalaInAction.demo_078.Spark
        println(classOf[Spark])  //class com.dt.scalaInAction.demo_078.Spark
    
        val spark = new Spark  
        println(spark.getClass)  //class com.dt.scalaInAction.demo_078.Spark
        println(spark.getClass == classOf[Spark]) //true
        
        println(classOf[Hadoop]) //interface com.dt.scalaInAction.demo_078.Hadoop
        println(typeOf[Hadoop])  //com.dt.scalaInAction.demo_078.Hadoop
        
        //单例  Flink$ 说明object的背后是有具体的类
        println(Flink.getClass)  //class com.dt.scalaInAction.demo_078.Flink$
        //println(classOf[Flink])  //not found: type Flink
       
        /**
         * classOf getClass的区别
         * getClass是表明当前类具体的子类
         * classOf是表明当前具体的类型       二者没有过多的区别
         */
        
        val java1 = new Java
        val java2 = new Java
        
        val scala1 = new java1.Scala //val scala1: java1.Scala
        val scala2 = new java2.Scala //val scala2: java2.Scala
        println(scala1.getClass)     //class com.dt.scalaInAction.demo_078.Java$Scala
        println(scala2.getClass)     //class com.dt.scalaInAction.demo_078.Java$Scala
        println(typeOf[java1.Scala] == typeOf[java2.Scala])  //false
        println(typeOf[java1.Scala]) //java1.Scala
        println(typeOf[java2.Scala]) //java2.Scala
        
        println(classOf[List[Int]] == classOf[List[String]]) //true
        println(typeOf[List[Int]] == typeOf[List[String]])   //false
        println(classOf[List[Int]])  //class scala.collection.immutable.List
        println(typeOf[List[Int]])   //scala.List[Int]
        
    }
}