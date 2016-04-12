package com.dt.scalaInAction.demo_055

/**
 * Scala中Infix Type实战详解
 */
object Infix_Types {
    def main(args: Array[String]): Unit = {
        
        object Log{
            def >>:(data: String):Log.type = {
                println(data)
                Log
            }
        }
        "Hadoop" >>: "Spark" >>: Log  //从右结合 相当于Log将"Spark"传入>>:方法返回Log在传入"Hadoop"
        /**
         * result:
         *   Spark
         *   Hadoop
         */
        
        
        val list = List()
        val newList = "A" :: "B" :: list
        println(newList)   //List(A, B)
      
        //表达一个泛型，这个泛型具有两个类型参数A B
        class Infix_Type[A, B]
        //使用的是 这样的方式直接指定A为Int类型 B为String类型  类型名称为Infix_Type
        //称之为中值类型 是因为类型名称写在两个参数之间
        val infix: Int Infix_Type String = null
        //等价于下面这种写法  上面的写法更具可读性
        val infix1: Infix_Type[Int, String] = null
        
        
        case class Cons(first: String, second: String)
        val case_class = Cons("one", "two")
        case_class match {
            //等价于 case Cons("one","two") => println("Spark")
            case "one" Cons "two" => println("Spark")
        }
        
        
    }
}