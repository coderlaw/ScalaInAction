package com.dt.scalaInAction.demo_029

/**
 * Case class和Case object代码实战解析
 * 注(1)case class中的成员默认下会是val的 只读的 这正适用于消息的传递
 *  (2)每个case class会有一个伴生对象 里面有apply方法  其中它的伴生对象会为我们构建出case class具体的对象
 */

abstract class Person
case class Student(age: Int) extends Person
case class Worker(age: Int, salary: Double) extends Person
case object Shared extends Person

object Case_Class_Object {
    def main(args: Array[String]): Unit = {
        def caseOps(person: Person) = person match {
            case Student(age) => println("I am " + age + "years old")
            case Worker(_, salary) => println("Wow, I got " + salary)
            case Shared => println("No property")
        }
        
        //Student这样的定义方式其实是调用了apply方法
        caseOps(Student(19))  //I am 19years old
        caseOps(Shared)       //No property
        
        val worker = Worker(29, 10000.1)
        val worker2 = worker.copy(salary = 19.95)
        val worker3 = worker.copy(age = 30)
    }
}