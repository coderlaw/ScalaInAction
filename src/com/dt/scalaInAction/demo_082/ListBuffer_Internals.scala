package com.dt.scalaInAction.demo_082

/**
 * Scala中List的构造是的类型约束逆变、协变、下界详解
 */
object ListBuffer_Internals {
    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(increment(list))
        println(increment_MoreEffective(list))
        println(increment_MostEffective(list))
    }
    
    def increment(list: List[Int]): List[Int] = list match {
        case List() => List()
        case head :: tail => head+1 :: increment(tail)
    }
    
    def increment_MoreEffective(list: List[Int]): List[Int] = {
        var result = List[Int]()
        for(e <- list) result = result ::: List(e+1)
        result
    }
    
    def increment_MostEffective(list: List[Int]): List[Int] = {
        import scala.collection.mutable.ListBuffer
        var buffer = new ListBuffer[Int]
        for(e <- list) buffer += e + 1
        buffer.toList
    }
    
}