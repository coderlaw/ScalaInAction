package com.dt.scalaInAction.demo_030

/**
 * 模式匹配高级实战：嵌套的Case class
 */

abstract class Item
case class Book(description: String, price: Double) extends Item
case class Bundle(description: String, price: Double, items: Item*) extends Item

object Pattern_Match_Case_Class_Nested {
    def main(args: Array[String]): Unit = {
      
        def caseclass_nested(person: Item) = person match {
          
           //art 是为了提取整个Book对象  相当于的取了个别名  将Book的case class作为一个引用
           case Bundle(_, _, art@Book(_, _), rest@_*) => println(art.description + ":" + art.price)
           
           //_* 表示匹配多个 可以有也可以没有
           case Bundle(_, _, Book(descr, _), _*) => println("The first description is " + descr)
           case _ => println("Oops!")
        }     
        
        caseclass_nested(
             Bundle("1111 Special's", 30.0,
             Book("Scala for the Spark Developer", 69.95),
             Bundle("Hadoop", 40.0,
                 Book("Hive", 79.95),
                 Book("HBase", 32.95)
             )
        ))    //row result: Scala for the Spark Developer:69.95
        
        
        
        caseclass_nested(
            Bundle(
                "1212 Special's",35.0,
                Book("Spark for the Impatient", 39.95)
            )
        )   //row result: Spark for the Impatient:39.95
        
    }
}