package com.dt.scalaInAction.demo_043

//class Pair[T](val first: T, val second: T)
/**
 * 类型的界定
 * 这里的[T <: Comparable[T]] 表示类型T必须是Comparable[T]的子类
 */
class Pair[T <: Comparable[T]](val first: T, val second: T) {
    def bigger = if(first.compareTo(second) > 0) first else second
}

/**
 * [R >: T]表示 R类型是T类型的父类
 * 类型变量的界定 就R而言 T为R的下界   就T而言 R为T的上界
 * 
 */
class Pair_Lower_Bound[T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new Pair_Lower_Bound[R](newFirst, second)
}

/**
 * Scala中类型变量Bounds代码实战及其在Spark中的应用源码解析
 * <:和>:
 */
object Type_Variable_Bounds {
  
    def main(args: Array[String]): Unit = {
        val pair = new Pair("Spark", "Hadoop")
        println(pair.bigger)  //Spark

    }
}