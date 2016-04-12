package com.dt.scalaInAction.demo_027

/**
 * Type、Array、List、Tuple模式匹配实战解析
 */
object Pattern_Match_More {
    def main(args: Array[String]): Unit = {
        
        /**
         * 通过模式匹配判断参数的类型
         */
        def match_type(t: Any) = t match {
            case p: Int => println("It is Integer") //这里的p变量 val p: Int  t会赋值给变量p
            case p: String => println("It is String, the content is " + p)
            case m: Map[_, _] => m.foreach(println)  //val m: Map[_, _]
            case _ => println("Unknow type!!!")
        }
        match_type(2)                         //It is Integer
        match_type("Spark")                   //It is String, the content is Spark
        match_type(Map("Scala" -> "Spark"))   //(Scala,Spark)
        
        /**
         * 模式匹配数组
         */
        def match_array(arr: Any) = arr match {
            case Array(0) => println("Array" + "0")
            case Array(x, y) => println("Array" + x + " " + y)  //匹配有两个元素的数组
            case Array(0, _*) => println("Array" + "0 ...")     //匹配至少是1个元素，并且第一个元素为0的数组  _*表示后面有许多元素
            case _ => println("something else")
        }
        match_array(Array(0))                    //Array0
        match_array(Array(0, 1))                 //Array0 1
        match_array(Array(0, 1, 2, 3, 4, 5, 6))  //Array0 ...
        
        
        /**
         * 模式匹配List
         */
        def match_list(lst: Any) = lst match {
            case 0 :: Nil => println("List" + "0")                //匹配有一个元素的且为0的集合
            case x :: y :: Nil => println("List" + x + " " + y)   //匹配有两个元素的集合
            case 0 :: tail => println("List" + "0 ...")           //x :: tail 表示开头的元素为0 tail表示剩下的若干个元素  匹配至少有一个元素的集合
            case _ => println("something else")
        }
        match_list(List(0))                  //List0
        match_list(List(0, 1))               //List0 1
        match_list(List(0, 1, 2, 3, 4, 5))   //List0 ...
        
        /**
         * 模式匹配Tuple元祖
         */
         def match_tuple(tuple: Any) = tuple match {
            case (0, _) => println("Tuple" + "0")   //匹配第一个元素为0，第二个元素任意
            case (x, 0) => println("Tuple:" + x)    
            case _ => println("something else")
        }
        match_tuple((0, "Scala"))         //Tuple0
        match_tuple((2, 0))               //Tuple:2
        match_tuple((0, 1, 2, 3, 4, 5))   //something else

    }
}