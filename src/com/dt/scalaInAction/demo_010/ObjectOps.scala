package com.dt.scalaInAction.demo_010

/**
 * 
 */
class University {
    val id = University.newStudentNo
    private var number = 0
    def aClass(number : Int) = {this.number += number}
}

/**
 * object可以作为一些静态方法区 静态变量区
 */
object University {
    private var studentNo = 0
    def newStudentNo = {
        studentNo += 1
        studentNo      //Scala中方法的最后一行就是方法的返回内容
    }
    private def call = {
        studentNo += 1
        studentNo     
    }
}
/**
 * Scala单例对象
 *      伴生对象 实战详解
 * (a)    
 * Scala没有像在Java中拥有静态类，静态成员，静态方法
 * Scala中提供了object对象类似于Java中的静态类  在Scala的object类中定义的所有成员和方法都是静态的
 * 
 * (b) 
 * 与Java不同的是 类中的静态成员 和方法 会在类加载时就会执行，即使不去调用
 * 而Scala中的object只有在第一次使用的时候才会执行  并不是加载的时候就去执行的
 * 
 * (c) 伴生类/伴生对象
 * class A   object A   这两个类名一样 
 * 则class A 为 object A的伴生类
 *   object A 为 class A的伴生对象
 * 而且class A 可以任意访问它的伴生对象中的所有成员 包括private级别的def
 * 注意:由于伴生对象的定义不在伴生类中 所以访问伴生对象中的成员 仍然是A.xxx的方式
 * 一般而言 可以吧伴生对象对象作为伴生类的封装区域 
 * 
 */
object ObjectOps {
    def main(args: Array[String]): Unit = {
      
        println("studentNo="+University.newStudentNo)  //1
        println("studentNo="+University.newStudentNo)  //2
        
        
        val arr = Array(1, 2, 3, 4)  //这样的定义数组其实底层就是采用类的伴生对象来构建的
    }
}