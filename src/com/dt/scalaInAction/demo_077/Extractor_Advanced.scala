package com.dt.scalaInAction.demo_077

/**
 * 模式匹配下的提取器动手构造实战
 */
object :> {
    def unapply[A] (list: List[A]) = {
        //list.init 除去最后一个元素的以前的元素
        //list.last 最后一个元素
        Some((list.init, list.last))
    }
}
object Extractor_Advanced {
    def main(args: Array[String]): Unit = {
        //_ :> 9 来匹配最后一个元素为9 前面的元素用_表示
        (1 to 9).toList match { case _ :> 9 => println("Hadoop") }

        //会把(1 to 9).toList作为参数传给unapply 返回具体匹配的内容
        (1 to 9).toList match { case x :> 8 :> 9 => println("Spark") }
        (1 to 9).toList match { case :>(:>(_,8),9) => println("Flink") }
      
    }
}