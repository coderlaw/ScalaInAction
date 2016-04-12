package com.dt.scalaInAction.demo_007

class Person { //class classname 默认为public级别的
    private var age = 0 //与Java不同 是这种方式定义必须赋值，否则编译报错   完全的定义为:private[this] var age: Int
    def increment(){age += 1}
    def current = age  //等价于def current() = age 没有参数可以省略括号
}

class Student {
    /**
     * private[this] var age: Int 
     * 
     * 在Java中定义private私有属性需要手动生成的getter和setter方法
     * 在Scala中 这种定义了private[this] var age: Int的属性会自动生成getter/setter
     */
    var age = 0    //这种var age = 0 的原型为private[this] var age: Int   并且会自动生成getter/setter
    private var ageA = 0 //这种private var ageA = 0 的原型仍然是private[this] 但是不会生成getter/setter
    
    
    private[this] var ageB = 0  //对象私有字段 限定这个属性为当前对象自己的方法能够访问的 不能被当前对象的类的方式去使用
    
    /**
     * 这种val的声明方式为只读模式  其原型为 private[this] val name: String
     * 会自动生成final类型的私有字段 和getter方法 不会生成setter方法
     */
    val name = "Scala"
    
    def isYonger(other : Student) = ageA < other.ageA  //如果将ageA定义为 private[this] var ageA = 0  编辑出错
}


/**
 * Scala类的属性和对象私有字段实战详解
 */
object HelloOOP {
    def main(args: Array[String]): Unit = {
        var person = new Person()
        person.increment()
        println(person.current)  //1
        
        //var stu = new Student   //等价于 var stu = new Student()
        /**
         * getter
         * stu.age 调用的是age私有属性的getter方法 并不是直接访问age属性
         * 鼠标上移有提示为def age: Int
         */
        //println(stu.age)   //0
        
        /**
         * setter
         * stu.age = 10 这种赋值方式不是将10赋值给age属性，而且age为private级别的 也无法访问
         * 其实是调用了setter方法
         * def age_=(x$1: Int): Unit
         * 
         */
        //stu.age = 10
        //println(stu.age)
        
        
        var stu = new Student
        /**
         * 这种访问方式是直接访问name属性
         */
        //stu.name = "Hadoop"  //编译报错 因为是只读模式
        println(stu.name)   //Scala
        
    }
}