package com.dt.scalaInAction.demo_081

/**
 * Scala中List的构造是的类型约束逆变、协变、下界详解
 */
abstract class BigData

class Hadoop extends BigData

class Spark extends BigData

object List_Constructor_Internals {
    def main(args: Array[String]): Unit = {
      
       /**
        *   def ::[B >: A] (x: B): List[B] =
        *        new scala.collection.immutable.::(x, this)
        * 
        **/
       val hadoop = new Hadoop :: Nil      //val hadoop: List[Hadoop]
       val big_Data = new Spark :: hadoop  //val big_Data: List[BigData]
    }
}