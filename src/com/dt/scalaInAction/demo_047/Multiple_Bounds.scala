package com.dt.scalaInAction.demo_047

class M_A[T]
class M_B[T]

/**
 * Scala多重界定代码实战及其在Spark中的应用源码解析
 *  
 * T <: A with B
 * T是A或者B的子类
 * 
 * T >: A with B
 * A或者B是T的子类
 * 
 * T >: A <: B (写法上 下界必须写在前面 上界必须写在后面)
 * T同时拥有下界A和上界B(A必为B的子类型) 但T不能同时拥有多个上界或多个下界
 * 
 * T : A : B(上下文界定)
 * 
 * 
 * T <% A <% B(视图界定)  T必须能够同时转化为A和B的要求
 * T可以<同时>拥有多个视图界定
 * T可以通过"隐式转换"为A 也可以"隐式转换"为B
 * 
 */
object Multiple_Bounds {
    def main(args: Array[String]): Unit = {
        implicit val a = new M_A[Int]
    		implicit val b = new M_B[Int]
        def foo[T : M_A : M_B](i: T) = println("Run")
        
        foo(2)
        
    }
}