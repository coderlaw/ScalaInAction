package com.dt.scalaInAction.demo_062

/**
 * Scala中上下文界定内幕中的隐式参数与隐式参数的实战详解及其在Spark中的应用源码解析
 */
//[T: Ordering] 这种写法 说明存在一个隐式类型Ordering[T]
class Pair_Implicits[T: Ordering](val first: T, val second: T){
    //声明一个隐式类型对象传入函数 
    def bigger(implicit ordered: Ordering[T]) = {
        if (ordered.compare(first, second) > 0) first else second
    }
}

class Pair_Implicitly[T: Ordering](val first: T, val second: T){
    def bigger = 
      /**
       *   在Predef中定义了implicitly一个方法 可以简化上面的写法
       *   @inline def implicitly[T](implicit e: T) = e 
       */
      if (implicitly[Ordering[T]].compare(first, second) > 0) first else second
}

class Pair_Implicitly_Ordereded[T: Ordering](val first: T, val second: T) {
    def bigger = {
        import Ordered._
        if (first > second) first else second
    }
}

object Context_Bounds_Internals {
  
    def main(args: Array[String]): Unit = {
      println(new Pair_Implicits(7, 9).bigger)
      println(new Pair_Implicitly(7, 9).bigger)
      println(new Pair_Implicitly_Ordereded(7, 9).bigger)
      
    }
}