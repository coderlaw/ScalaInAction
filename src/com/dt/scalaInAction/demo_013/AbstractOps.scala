package com.dt.scalaInAction.demo_013

class AbstractClass{
    //在普通类中 字段必须赋值(有两种方式1.赋具体的值 2."_"占位赋值方法 表明只占位但没有具体的值)
    var id: Int = _   //注意 这种方式必须声明为var 不可以定义为val 原因是因为_的值不明确
}
abstract class SuperTeacher(val name: String){
    var id : Int  //抽象字段定义 只需赋值 即为抽象字段
    var age : Int
    def teach  //抽象方法定义:与Java不同的是 方法定义不需要有 abstract声明，只需不写方法体即可
}

class TeacherForMaths(name: String) extends SuperTeacher(name) {
    override var id = name.hashCode()  //override 可以不写   采用override标识为复写属性
    override var age = 29
    override def teach = println("teaching Math");
}

/**
 * 抽象类、抽象字段、抽象方法
 */
object AbstractOps {
    def main(args: Array[String]): Unit = {
        val teacher = new TeacherForMaths("Spark")
        teacher.teach                       //row result : teaching Math
        
        println("teacher.id:"+teacher.id)   //row result : teacher.id:80085693
        println("teacher.age:"+teacher.age) //row result : teacher.age:29
    }
}