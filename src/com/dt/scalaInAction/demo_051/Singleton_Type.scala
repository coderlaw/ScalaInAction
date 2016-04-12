package com.dt.scalaInAction.demo_051

/**
 * Scala中链式调用风格的实现代码实战及其在Spark编程中的广泛运用
 */


//1
class Animal {
    def breathe : this.type = this
}
class Cat extends Animal {
    def eat : this.type = this
}

//2
/*class Animal {
    def breathe  = this
}
class Cat extends Animal {
    def eat  = this
}*/

object Singleton_Type {
    def main(args: Array[String]): Unit = {
      
      val cat = new Cat
      
      /*
       * 代码2 报错
       * cat.breathe 返回的是Animal的this Animal实例没有eat方法 所以报错
       */
      /*
       * 为了到达链式调用 采用代码1
       * 注意:this.type = this
       * 
       * Q:type是指什么？
       * A:在Scala中 任何类对象都有一个type属性
       * 
       * 当执行cat.breathe其实返回的Cat类实例的type 而这个type有eat方法
       */
      println(cat.breathe)
    }
}