package com.dt.scalaInAction.demo_003

/**
 * Map
 */
object MapOps {
  def main(args: Array[String]): Unit = {
    /**
     * 不可变的map
     */
    var entry = Map("John"->21,"Bell"->24)  //Map的静态定义    var entry: Map[String, Int]
    /**
     * 移除某个键和对应的值
     */
    entry -= "John"
    /**
     * 检查映射中是否含有某个指定的键
     */
    var john = entry.contains("John")
    println(john)
    /**
     * 增加键和值
     */
    entry +=("Bob"->30,"bbbb"->7)
    /**
     * 可变的map.HashMap形式
     */
    val scores = scala.collection.mutable.HashMap("Alice"->10,"bob"->3)
    /**
     * 树形映射
     */
    val scoressortedmap = scala.collection.immutable.SortedMap("Alice" -> 10,"Bob" -> 9)
    scores("bob") = 4
    /**
     * 空的映射
     */
    //val scores = new scala.collection.mutable.HashMap[String,Int]
    /**
     * 遍历k v  采用Tuple的方式遍历
     */
    for((k, v) <- entry) println("key="+k+";value="+v)
     
    /**
     * 翻转k,v
     */
    for((k, v) <- entry) yield (v,k)
    for((v, k) <- entry) println("key="+k+";value="+v)
    
    
    /**
     * 遍历k 忽略v
     */
    //for((k, _) <- entry) println("key="+k)   //(k, _) _为占位符
    
    /**
     * 根据k取v
     */
    var v = entry.get("John")
    var s = scores.get("bob")
//    println(s)
//    println(entry.getOrElse("bob", "bobb"))
    
    /**
     * val 不可变
     * var 可变
     */
    val a = 5
    var b = 5
    b = 6
  }
}