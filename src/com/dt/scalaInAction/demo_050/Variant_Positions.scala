package com.dt.scalaInAction.demo_050

//class P[+T](var first: T, var second: T)  error
class P[+T](val first: T, val second: T) 
{
//  def replaceFirst(newFirst: T) = new P[T](newFirst, second) //error
    
    //方法是泛型的  方法的参数是逆变点 返回值是协变的协变点
    def replaceFirst[R >: T](newFirst: R) = new P[R](newFirst, second)
}
/**
 * Scala中Variance变化点及其在Spark中的应用源码解析
 */
object Variant_Positions {
    def main(args: Array[String]): Unit = {
        
    }
}