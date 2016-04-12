package com.dt.scalaInAction.demo_003

/**
 * 数组
 */
object ArrayOps {
  def main(args: Array[String]): Unit = {
    var array = Array(1,2,3,4,5);  //数组发的静态定义    类型为 Array[Int]
    
    /**
     * 遍历方式一
     */
    for(index <- 0 until array.length ) println(array(index))
    
    /**
     * 遍历方式二(常用)
     */
    for(e <- array) println(e)
    
  }
}