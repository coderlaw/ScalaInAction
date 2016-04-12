package com.dt.scalaInAction.demo_040

import scala.collection.immutable.TreeSet
import scala.collection.immutable.TreeMap

/**
 * Set、Map、TreeSet、TreeMap操作代码实战
 */
object Set_Map {
    def main(args: Array[String]): Unit = {
        //mutable.Set
        val data = scala.collection.mutable.Set.empty[Int]
        //加入集合
        data ++= List(1, 2, 3)
        println(data)   //Set(1, 2, 3)
        data += 4
        println(data)   //Set(1, 2, 3, 4)
        //移除集合
        data --= List(2, 3)
        println(data)   //Set(1, 4)
        
        data += 1
        println(data)   //Set(1, 4)
        
        data.clear
        println(data)   //Set()
        
        
        //mutable.Map  
        val map = scala.collection.mutable.Map.empty[String, String]
        //添加键值
        map("Java") = "Hadoop"
        map("Scala") = "Spark"
        //覆盖修改
        map("Java") = "xxx"  // 等价于 map.put("Java", "xxx")
        println(map)  //Map(Scala -> Spark, Java -> Hadoop)
        println(map("Scala"))  //Spark
        
        //immutable.TreeSet 有序的Set
        val treeSet = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
        println(treeSet)  //TreeSet(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val treeSetForChar = TreeSet("Spark", "Hadoop", "Scala")
        println(treeSetForChar)  //TreeSet(Hadoop, Scala, Spark)
         
        //immutable.TreeMap  
        val treeMap = TreeMap("Scala" -> "Spark", "Java" -> "xxx", "j" -> "k")
        println(treeMap)   //Map(Java -> xxx, Scala -> Spark, j -> k)
        
        
    }
}