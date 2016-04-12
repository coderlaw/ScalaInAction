package com.dt.scalaInAction.demo_035

/**
 * List的map、flatMap、foreach、filter操作代码实战
 * map:作用于集合中每个元素 在组合成一个新的集合
 * flatMap 将所有元素集合中 的元素合并为一个集合  e.g {List(1, 2),List(2, 3) ...} => List(1, 2, 2, 3)
 * foreach 迭代每个元素 返回一个无返回值的函数操作 比如常用的遍历 foreach(println)
 * filter 过滤出符合提交的元素 在组合成一个新的集合  参数是一个 返回值为Boolean类型的函数
 */
object List_HighOrder_Function_Ops {
    def main(args: Array[String]): Unit = {
        println(List(1, 2, 3, 4, 6).map(_  + 1))   //等价于 List(1, 2, 3, 4, 6).map(item => item  + 1)
        //List(2, 3, 4, 5, 7)
        
        val data = List("Scala", "Hadoop", "Spark")
        println(data map (_.length))                   
        //List(5, 6, 5)
        
        println(data map (_.toList.reverse.mkString))  
        //List(alacS, poodaH, krapS)
        
        println(data.map(_.toList))
        //List(List(S, c, a, l, a), List(H, a, d, o, o, p), List(S, p, a, r, k))
        
        println(data.flatMap(_.toList))
        //List(S, c, a, l, a, H, a, d, o, o, p, S, p, a, r, k)
        
        println(List.range(1, 10) flatMap (i => List.range(1, i) map (j => (i, j) ) ) )
        //range(1, 10) ==> List(1, 2, 3, 4, 5, 6, 7, 8, 9)  <==> [1,...10)
        //List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,3), (6,4), (6,5), (7,1), (7,2), (7,3), (7,4), (7,5), (7,6), (8,1), (8,2), (8,3), (8,4), (8,5), (8,6), (8,7), (9,1), (9,2), (9,3), (9,4), (9,5), (9,6), (9,7), (9,8))
     
        var sum = 0
        List(1, 2, 3, 4, 5) foreach (sum += _)
        println("sum=" + sum)                //sum=15
        
        println(List(1, 2, 3, 4,6, 7, 8, 9, 10) filter (_ % 2 == 0))
        //List(2, 4, 6, 8, 10)
        
        println(data filter (_.length == 5))
        //List(Scala, Spark)
    }
}