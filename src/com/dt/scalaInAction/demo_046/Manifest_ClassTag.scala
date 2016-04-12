package com.dt.scalaInAction.demo_046

import scala.reflect.ClassTag

/**
 * ClassTag 、Manifest、ClassManifest、TypeTag代码实战及其在Spark中的应用源码解析
 * 
 * ClassTag ==> ClassManifest
 * TypeTag  ==> Manifest
 */
object Manifest_ClassTag {
    def main(args: Array[String]): Unit = {
        
        /**
         * Q: 可以创建泛型数组吗? 理论上是不可以的，因为没有指定具体的，在Scala程序运行中，数组必须有具体的类型，没有否无法创建的相应的数组
         * 
         * 引出Manifest的概念可以创建泛型数组
         * [T : Manifest]这样的写法被称之为Manifest上下文界定  实质上这是需要一个Manifest[T]类型的隐式对象 这又是一个"隐式转换"的过程
         * 通过这个隐式的值来辅助构建泛型数组，来确定T的具体类型
         * 所以在创建泛型函数时 需要Manifest的类型来辅助构建泛型数组，借助Manifest类型对象来指定泛型数组具体的类型
         * 
         * 通过Manifest[T]可以记录T的类型 在实际运行的时候我们获取T具体的类型
         * */
        def arrayMake[T : Manifest](first: T, second: T) = {
           val r = new Array[T](2) 
           r(0) = first
           r(1) = second
           r
        }
        arrayMake(1, 2).foreach(println)  //1 2
        
        /**
         * Manifest的原生写法  不推荐
         */
        def manif[T](x: List[T])(implicit m: Manifest[T]) = {
            if (m <:< manifest[String])   //<:< 表示 m是manifest[String]类型
              println("List Strings")
            else
              println("Some other type")
        }
        manif(List("Spark", "Hadoop"))   //List Strings
        manif(List(1, 2))                //Some other type
        manif(List("Scala", 3))          //Some other type
        
//        val m = manifest[A[String]]
//        println(m)
//        val m = classManifest[A[String]]
//        println(m)
        
        /**
         * [T : ClassTag]这种写法说明 当这个函数在运行时时 对存在一个ClassTag[T]一个隐式值 这种方式是最常用的
         */
        def mkArray[T : ClassTag](elems: T*) = Array[T](elems: _*)
        mkArray(42, 13).foreach(println)  //42  13
        mkArray("Japan", "Brazil", "Germany").foreach(println)   //"Japan", "Brazil", "Germany"
        
        
        
    }
}