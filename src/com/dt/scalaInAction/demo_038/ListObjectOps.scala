package com.dt.scalaInAction.demo_038

/**
 * List伴生对象操作方法代码实战
 * apply make range unzip flatten concat map2
 */
object ListObjectOps {
    def main(args: Array[String]): Unit = {
        //apply:根据元素构建集合
        println(List.apply(1, 2, 3))    //List(1, 2, 3)
        //make:重复构建元素 第一个参数为构建个数,第二个为需要赋值的元素
        println(List.make(7, 5))        //List(5, 5, 5, 5, 5, 5, 5)
        //range:构建元素集合
        println(List.range(1, 5))       //List(1, 2, 3, 4)
        //range:构建元素集合 最后的一个参数为元素之间的步长
        println(List.range(9, 1, -1))   //List(9, 8, 7, 6, 5, 4, 3, 2)
        
        val zipped = "abcde".toList zip List(1, 2, 3, 4, 5)
        println(zipped)        //List((a,1), (b,2), (c,3), (d,4), (e,5))
        println(zipped.unzip)  //(List(a, b, c, d, e),List(1, 2, 3, 4, 5))
        
        //flatten 将多个集合中的元素放入到一个集合中
        println(List(List('a','b'), List('a'), List('d','e')).flatten)
        //List(a, b, a, d, e)
        
        //concat 类似flatten  将多个集合中的元素添加到一个新的集合中
        println(List.concat(List(), List('b'), List('c')))
        //List(b, c)
        
        //map2 两个集合中 索引相同的元素之前的操作后的值 放入一个新的集合中
        //def map2[A, B, C](xs: List[A], ys: List[B])(f: (A, B) => C): List[C]
        println(List.map2(List(10, 20), List(10, 10)) (_*_))
        //List(100, 200)
    }
}