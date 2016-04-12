package com.dt.scalaInAction.demo_079
import scala.reflect.runtime.universe._
/**
 * 单例深入讲解及单例背后的链式表达式
 */
object Scala
class Java1
class JVM {
    def method1: this.type = this
}
class JVM_Language extends JVM {
    def method2: this.type = this
}
object Singleton_Type {
    def main(args: Array[String]): Unit = {
        println(Scala.getClass)          //class com.dt.scalaInAction.demo_079.Scala$
        println(typeOf[Scala.type])      //com.dt.scalaInAction.demo_079.Scala.type
        
        val java = new Java1
        val java2 = new Java1
        //这说明 每个实例对象都有唯一的单例 type是单例类型 只有当前这个单例唯一的实例
        println(typeOf[java.type])       //java.type
        println(typeOf[java2.type])      //java2.type
        
        val content:java.type  = java    //val content: Java1
       // val content:java.type  = java2
        
        val jvm = new JVM_Language        //val jvm: JVM_Language
        jvm.method1.method2
    }
}