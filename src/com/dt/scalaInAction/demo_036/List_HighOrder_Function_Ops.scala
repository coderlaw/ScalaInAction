package com.dt.scalaInAction.demo_036

/**
 * List的partition、find、takeWhile、dropWhile、span、forall、exsists操作代码实战
 */
object List_HighOrder_Function_Ops {
    def main(args: Array[String]): Unit = {
      
        //partition:按照某种条件对数据进行分类
        //def partition(p: A => Boolean): (Repr, Repr)
        println(List(1, 2, 3, 4, 5) partition (_ % 2 == 0))
        //(List(2, 4),List(1, 3, 5))
      
        //find:查找集合第一个符合条件的元素
        //def find(p: A => Boolean): Option[A]
        println(List(1, 2, 3, 4, 5) find (_ % 2 == 0)) //Some(2)
        println(List(1, 2, 3, 4, 5) find (_ <= 0))     //None
        
        //takeWhile:着个匹配符合条件的元素 直到不符合条件 之后的元素不在判断
        //override def takeWhile(p: A => Boolean): List[A]
        println(List(6, 5, 2, 3, 5) takeWhile (_ < 4))
        //List()
        
        //dropWhile:着个匹配去除符合条件的元素 直到不符合条件 之后的元素不在判断
        //override def dropWhile(p: A => Boolean): List[A]
        println(List(1, 2, 6, 4, 5) dropWhile (_ < 4))
        //List(6, 4, 5)
      
        //span 着个匹配按照某种条件对数据进行分类 直到不符合条件 之后的元素不在判断
        //override def span(p: A => Boolean): (List[A], List[A])
        println(List(1, 7, 3, 4, 5) span (_ < 4))
        //(List(1),List(7, 3, 4, 5))
        
        //forall  当所有的元素满足条件时 返回true 否则返回false
        //def forall(p: A => Boolean): Boolean
        println(List(1, 7, 3, 4, 5) forall (_ >= 4))   //false
        println(List(11, 7, 13, 4, 5) forall (_ >= 4)) //true
        println
        
        //exists  当存在(至少有一个满足)元素满足条件时 返回true 否则返回false
        //def exists(p: A => Boolean): Boolean
        println(List(1, 7, 3, 4, 5) exists (_ >= 4))   //true
        println(List(11, 7, 13, 4, 5) exists (_ >= 4)) //true
        
        println
        def hastotallyZeroRow(m: List[List[Int]]) = m exists (row => row forall (_ == 0))
        val m = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 0))
        println(hastotallyZeroRow(m))   //true
        
    }
}