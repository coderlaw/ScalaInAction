package com.dt.scalaInAction.demo_012

/**
 * Scala中的继承：超类的构造、重写字段、重写方法
 */
object OverrideOps {
    def main(args: Array[String]): Unit = {
        val worker = new Worker("Spark", 5, 100000);
        //row result : The primary constructor of Person
        //             The is the subClass of Person, primary constructor of Worker

        println("School:"+worker.school)  //row result : School:Spark
        println("Salary:"+worker.salary)  //row result : Salary:100000
        println(worker)                   //row result : I am a Worker 8 hour
    }
}

class Person(val name: String, var age: Int){
    println("The primary constructor of Person")
    val school = "BJU"
    def sleep = "8 hour"
    /*
     * 编码规则 复写方法需要标明override 关键字
     */
    override def toString = "I am a Person"
}

/**
 * Worker继承 Person
 * 子类在继承父类时 
 * 1.需要调用父类的主构造器 在子类声明时必须需要将父类的主构造器参数全部传递给子类的主构造器 否则编译报错
 * 2.编码规则 复写方法或者字段需要标明override 关键字
 */
class Worker(name: String, age: Int, val salary: Long) extends Person(name, age) {
    println("The is the subClass of Person, primary constructor of Worker")
    override val school = "Spark"   //复写父类的字段
    override def toString = "I am a Worker " + super.sleep  //在子类中调用父类的方法 需要使用super关键字
}