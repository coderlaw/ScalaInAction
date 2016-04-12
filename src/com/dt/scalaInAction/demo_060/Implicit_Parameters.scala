package com.dt.scalaInAction.demo_060

/**
 * Scala中隐式参数实战详解以及隐式参数在Spark中的应用源码解析
 */
object Context_Implicits {
    implicit val default: String = "Java"
}
object Param {
    //函数中用implicit关键字 定义隐式参数
    def print(context: String)(implicit language: String){
        println(language+":"+context)
    }
}
object Implicit_Parameters {
    def main(args: Array[String]): Unit = {
        //隐式参数正常是可以传值的，和普通函数传值一样
        Param.print("Spark")("Scala")   //Scala:Spark
        
        import Context_Implicits._
        //隐式参数没有传值，编译器会在全局范围内搜索 有没有implicit String类型的隐式值 并传入
        Param.print("Hadoop")          //Java:Hadoop
    }
}