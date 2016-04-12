package com.dt.scalaInAction.demo_003

/**
 * 元祖
 * 从1下标开始取值
 * 使用元组的原因之一是把多个值绑在一起，以便它们能够被一起处理,用zip方法来处理
 */
object TupleOps {
  
  def main(args: Array[String]): Unit = {
    var pair = (100, "Scala", "Spark")  //注意 鼠标上移变量pair 显示var pair: (Int, String, String) 这是Scala的类型推断
//    println(pair._0); //注意:去元素是下标从1开始  ._0 会编译错误
    println(pair._1)
    println(pair._2)
    /**
     * 这里可以用空格 代表.
     */
    println(pair _3)
    
    /**
     * 遍历元组
     */
    pair.productIterator.foreach{ i =>println("Value = " + i )}
    
    /**
     * 得到对偶
     */
    val n = "NewDD York".partition(_.isUpper)
    println(n)
    
    
    
    /**
     * zip处理元组
     */
    val symbols = Array("<","-",">")
    val counts = Array(2,10,2 )
    val pairs = symbols.zip(counts)
    /**
     * 得到对偶的数组：Array(("<",2),("-",10),(">",2))
     */
    println(pairs)
    
    /**
     * 输出2个< 10个- 2个>
     * 
     * <-操作符是什么意思?
     */
    for((s,n) <- pairs) print(s*n)
    
  }
  
}