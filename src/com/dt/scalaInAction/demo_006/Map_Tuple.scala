package com.dt.scalaInAction.demo_006

/**
 * Map、Tuple、Zip实战解析
 */
object Map_Tuple {
    def main(args: Array[String]): Unit = {
        //静态定义map集合 注意这个map是不可变的  immutable
        var map = Map("book"->23,"gun"->21,"ipad"->20)  //var map: Map[String, Int]
        //通过模式匹配 做变换 注意此操作不影响原来的map集合  生成新的map集合 因为这种map是immutable类型的
        var map1 = for((k, v) <- map ) yield (k, v * 0.9)
        println(map)     //  Map(book -> 23, gun -> 21, ipad -> 20)
        println(map1)    //  Map(book -> 20.7, gun -> 18.900000000000002, ipad -> 18.0)
        
        
        //定义可修改的map集合  mutable
        val scores = scala.collection.mutable.Map("Scala"->7, "Spark"->8, "Hadoop"->9)
        //取值
        val hadoop = scores.get("Hadoop")  //Some(9)
        println("hadoop="+hadoop)
        //getOrElse  取key为x的值 若不存在返回函数中第二个值
        val x = scores.getOrElse("x", 1)  //1
        println("x="+x)
        //增加元素
        scores += ("R"->9)    //Map(Hadoop -> 9, R -> 9, Spark -> 8, Scala -> 7)
        //删除元素
        scores -= "Hadoop"    //Map(R -> 9, Spark -> 8, Scala -> 7)
        
        //按照key的然后顺序排序
        val scoreMap = scala.collection.immutable.SortedMap("Scala"->7, "Spark"->8, "Hadoop"->9)  //Map(Hadoop -> 9, Scala -> 7, Spark -> 8)

    
        
        /**
         * 元祖
         */
        //定义元祖
        val tuple = (1, 2, 3, "Spark", "Scala")  //Map(Hadoop -> 9, Scala -> 7, Spark -> 8)
        //通过下标取值 (是从1开始取值)
        val thrid = tuple._3   //3
        println("thrid="+thrid)
        
        /**
         * 如何接收tuple中的值
         */
        val (one, two, three, four, fire) = tuple
        println("one="+one+" two="+two+" three="+three+" four="+four+" fire="+fire)
        //忽略接收
        val (j, k, _, _, _) = tuple
        println("j="+j+" k="+k)
        
        //def partition(p: Char => Boolean): (String, String)
        val (a, b) = "Spark Hadoop".partition(_.isUpper)
        println("a="+a+" b="+b)   //a=SH b=park adoop
        
        
        
        
        /*
         * zip操作
         */
        val symbols = Array("[", "-", "]")
        val counts = Array(2, 5, 2)
        val pairs = symbols.zip(counts)   //val pairs: Array[(String, Int)]
        for (e <- pairs) println(e)  //([,2) (-,5)  (],2)
        for ((x, y) <- pairs) print(x*y)  //[[-----]]
        
        
    }
}