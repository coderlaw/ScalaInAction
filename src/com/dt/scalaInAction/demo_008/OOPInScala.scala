package com.dt.scalaInAction.demo_008


class Teacher { //class Teacher() 也可行  不写"()"则()为类默认的无参的主构造器
  var name : String = _     //通过_ 给属性赋值表示当前没有值 不赋值则编辑报错  这种定义方式编译器会生成共有的getter/setter方法
  private var age = 27      //这种定义方式编译器会生成私有的getter/setter方法
  private[this] var gender = "male"  //这种private[this]定义的方式 这个变量只属于当前的实例
  
  /**
   * 在类的内部定义一个构造器
   * 注意: (1)这个构造器的this这一行不可以省略 它是在调用类的默认的构造器
   *      (2)这个是类的附属构造器 而每个附属构造器必须调用其他的附属构造器， 从最终形态上来看一定会调用类的主构造器
   */
  def this(name : String) {
      this   //不能省略  this() 也可行
      this.name = name
  }
  
  def sayHello = println(this.name+":"+this.age+":"+this.gender)
  
}


/**
 * 定义有参主构造器的类 
 * 注意:在主构造器中声明var 或者 val的变量 都将成为类的成员
 * 
 */
class Teacher_(val name:String, val age:Int) {
    println("This is the primary constructor...")
    var gender : String = _
    println("gender="+gender) //null
    def this(name:String, age:Int, gender:String) {
        this(name, age)
        this.gender = gender
    }
}

/**
 * 定义有参主构造器的类  但不希望调用者使用主构造器
 * 
 */
class Teacher2 private(val name:String, val age:Int) {
    println("This is the primary constructor...")
    var gender : String = _
    println("gender="+gender) //null
    def this(name:String, age:Int, gender:String) {
        this(name, age)
        this.gender = gender
    }
}

/**
 * Scala主构造器
 *      私有构造器
 *      构造器重载实战详解
 */
object OOPInScala {
    def main(args: Array[String]): Unit = {
        var t = new Teacher;
        t.name = "Spark"
        //t.gender  无法访问
        t.sayHello      //Spark:27:male

        
        
        
        var t1 = new Teacher_("Spark", 17)
        println(t1.name+":"+t1.age)
        /*
         *  结果为:
         *  This is the primary constructor...
            gender=null
            Spark:17
         */
        
        
        
        var t2 = new Teacher_("Spark", 17, "male")
        println(t2.name+":"+t2.age+":"+t2.gender)
        /**
         *  结果为:
         *  This is the primary constructor...
            gender=null
            Spark:17:male
         */
        
        
        
        
        //var t3 = new Teacher2("Spark", 17)    //编译报错  由于主构造器 私有化 只能使用非主构造器
        var t4 = new Teacher_("Spark", 17, "male")  //定义正确
        
    }
}