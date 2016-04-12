package com.dt.scalaInAction.demo_056

/**
 * Scala中Self Types实战详解
 */
class Self {
    //用法一：self => 表示this的别名 这是self和this等价   注意不能使用this作为别名
    self =>
    val tmp = "Scala"
    def foo = self.tmp + this.tmp
}

trait S1
class S2 {
    /**
     * 用法二：
     * 这种方式和self =>并不一样  将S1比如为摸个trait是
     * 这种this:S1为this的别名时 有一个强制的要求 
     * (1)在该类型实例化时 必须混入这个类型 即: val c = new S2 with S1 否则报错
     * (2)在继承该类的子类是 也必须混入 比如:class S3 extends S2 with S1  若不混入with S1则报错
     */
    this:S1 =>
}
class S3 extends S2 with S1

trait T {this:S1 =>}
object S4 extends T with S1

object Self_Types {
    def main(args: Array[String]): Unit = {
        class Outer {
            outer =>
            val v1 = "Spark"
            class Inner {
                /*
                 * 用法三：
                 * 这里内部类需要访问外部类成员和方法  
                 * 通过定义了outer =>代替了外部类Outer的this 在内部类理由直接引用不需要考虑this是谁this 这是使用这种方式声明的好处
                 * 
                 * 如果写成println(this.v1)则报错 因为这个this代表了Inner的this
                 * 下面的三种写法都是正确的
                 */
                println(v1)
                println(outer.v1)
                println(Outer.this.v1)
                
            }
        }
        val c = new S2 with S1 //val c: S2 with S1 { .. }
    }
}