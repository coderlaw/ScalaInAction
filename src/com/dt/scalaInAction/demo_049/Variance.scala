package com.dt.scalaInAction.demo_049

/**
 * Scala中Variance代码实战及其在Spark中的应用源码解析
 * 
 * 通俗讲
 * B是A的子类 ==>List[B]是List[A]的子类(与具体元素的继承关系同向)  这样称之为"协变"  
 * B是A的子类 ==>List[A]是List[B]的子类(与具体元素的继承关系反向)  这样称之为"逆变"  
 * 如果支持上面的这种概念 就被称之为"Variance" 否则称之为"inVariance"
 * 
 * 事实上Java不支持在定义一个类型时声明为这样的"Variance"
 * e.g. String是object的子类 List<String> 却不是 List<Object>的子类
 * 但是Java中是存在这样的痕迹的 比如:
 * List<? extends Object> list = new ArrayList<String>()
 * 在Scala中也是可以向上面这样写的:
 * val list: List[_ <: Any] = List[String]("Spark", "Hadoop")
 * 
 * 事实上Java支持在使用的时候 可以这样去定义，在声明的时候不支持，但是Scala中的可以
 * 
 * Scala中 在声明时留意表达这种Variance的关系
 * 形如class C[+T] “+”表示"协变" 也就是说若B为A的子类型 则C[B]是C[A]的子类型
 *    class C[-T] “-”表示"协变" 也就是说若B为A的子类型 则C[A]是C[B]的子类型
 *    
 */
class Person
class Student extends Person
class C[+T] (val args: T)
//注意:C类型是支持"协变"的 C的子类型S也必须是支持"协变"的
class S[+T](args: T) extends C[T](args)

trait Friend[-T]{
    def makeFriend(someBody: T)
}

object Variance {
    def makeFriendWithYou(s: Student, f: Friend[Student]){f.makeFriend(s)}
    def main(args: Array[String]): Unit = {
        val value: C[Person] = new C[Student](new Student)
    }
}