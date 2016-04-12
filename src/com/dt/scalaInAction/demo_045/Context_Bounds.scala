package com.dt.scalaInAction.demo_045

/**
 * 上下文界定  [T : Ordering]  说明存在一个隐式的值Ordering[T]    //implicit ordered: Ordering[T]
 * 
 * Ordering源码声明:
 * trait Ordering[T] extends Comparator[T] with PartialOrdering[T] with Serializable 
 */
class Pair_Ordering[T : Ordering] (val first: T, val second: T) {
  
    //这是一个隐式转换的显式定义 这个函数没有参数 当时函数执行的时候 这个隐式值就会自动传进来
    def bigger(implicit ordered: Ordering[T]) = {
        if (ordered.compare(first, second) > 0) first else second
    }
}


/**
 * Scala中Context Bounds代码实战及其在Spark中的应用源码解析
 * 
 */
object Context_Bounds {
    def main(args: Array[String]): Unit = {
        val pair = new Pair_Ordering("Spark", "Hadoop")
        println(pair.bigger)    //Spark
        
        val pairInt = new Pair_Ordering(3, 5)
        println(pairInt.bigger) //5
    }
}