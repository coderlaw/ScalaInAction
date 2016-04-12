package com.dt.scalaInAction.demo_031

/**
 * Option使用和实现内幕源码揭秘
 * 
 * Option的源码定义
 * sealed abstract class Option[+A] extends Product with Serializable...
 * 
 * sealed关键字定义有一个强制的要求:Option下定义的所有的case class和case object都必须在同一个文件中
 * 
 * Option有两个直接实现子类
 * Some:Option中具体的值
 * None:Option没有具体的值
 * 
 * final case class Some[+A](x: A) extends Option[A] {
      def isEmpty = false
      def get = x
   }
   
   case object None extends Option[Nothing] {
      def isEmpty = true
      def get = throw new NoSuchElementException("None.get")
   }
   
 */
object OptionOps {
      def main(args: Array[String]): Unit = {
         val score = Map("Alice" -> 99, "Spark" -> 100)
         
         //def get(key: String): Option[Int]
         score.get("Alice") match {
           case Some(score) => println("score=" + score)
           case None => println("No core")
         }
         
         println(score.get("Alice"))  //Some(99)

        
      }
}