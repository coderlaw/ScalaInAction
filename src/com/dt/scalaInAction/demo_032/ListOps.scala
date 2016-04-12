package com.dt.scalaInAction.demo_032

/**
 * List的基本操作实战与基于模式匹配的List排序算法实现
 */
object ListOps {
    def main(args: Array[String]): Unit = {
        val bigData = List("Hadoop", "Spark")  //val bigData: List[String]
        /**
         * 这种不通过new的方式实例化 的实质是调用的它的apply方法
         * 
         * override def apply[A](xs: A*): List[A] = xs.toList
         */
        val data = List(1, "2", 3)   //val data: List[Any]
        
        /**
         * Scala中的List只有两部分构成 
         * (1)head:第一个元素
         * (2)tail:其他所有的元素
         */
        val bigData_Core = "Hadoop" :: ("Spark" :: Nil)  //Nil表示空元素  ::是一个函数 结合方向是 从右向左
        val data_Int = 1 :: 2 :: 3 :: Nil
        
        println(data.isEmpty)    //false
        println(data.head)       //1
        println(data.tail.head)  //2
        
        
        /**
         * List模式匹配风格的赋值
         */
        //1
        val List(a, b) = bigData
        println("a="+a+" b="+b)     //a=Hadoop b=Spark
        //2
        val x::y::rest = data
        println("x="+x+" y="+y+" rest="+rest)  //x=1 y=2 rest=List(3)
        
        //使用模式匹配 对List中的元素进行排序
        val shuffledData = List(6, 3, 5, 6, 2, 9, 1)
        println(sortList(shuffledData))   //List(1, 2, 3, 5, 6, 6, 9)
        
        def sortList(list: List[Int]): List[Int] = list match {
            case List() => List()
            case head :: tail =>compute(head, sortList(tail))
        } 
        
        def compute(data: Int, dataSet: List[Int]): List[Int] = dataSet match {
           case List() => List(data)
           case head :: tail => if (data <= head) data :: dataSet
           else head :: compute(data, tail)
        }
        
    }
}