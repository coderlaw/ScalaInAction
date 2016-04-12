package com.dt.scalaInAction.demo_033

/**
 * List的一阶函数操作代码实战详解
 */
object List_FirstOrder {
    def main(args: Array[String]): Unit = {
        //方法 :: 为连接元素  
        //方法 ::: 为连接列表
        println(List(1,2,3,4):::List(4,5,6,7,8):::List(10,11))
        println(List(1,2,3,4):::(List(4,5,6,7,8):::List(10,11)))
        //List(1, 2, 3, 4, 4, 5, 6, 7, 8, 10, 11)
        
        //求长  .length方法来判断集合是否为空 效率不高 应多用 isEmpty
        println(List(1,2,3,4).length)   //4
      
        val bigData = List("Hadoop", "Spark", "Kaffka")
        //获得最后一个元素
        println("last "+bigData.last)           //last Kaffka
        //获得除去最后一个元素的其他元素
        println("init "+bigData.init)           //init List(Hadoop, Spark)
        //倒序反转 产生新的List
        println("reverse "+bigData.reverse)     //reverse List(Kaffka, Spark, Hadoop)
        //reverse没有影响原先的List  证明List是不可变的
        println("bigData "+bigData)             //bigData List(Hadoop, Spark, Kaffka)
        //获取前n个元素组成集合
        println("take "+bigData.take(2))        //take List(Hadoop, Spark)
        //去除前n个元素 剩余的元素组成集合
        println("drop "+bigData.drop(2))        //drop List(Kaffka)
        //将集合分为两部分 这两部分List在组成一个List 以前n个作为分隔线
        println("splitAt "+bigData.splitAt(2))  //splitAt (List(Hadoop, Spark),List(Kaffka))
        //通过索引查找元素  等价于bigData(2)
        println("apply "+bigData.apply(2))      //apply Kaffka
        //通过索引查找元素 def apply(n: Int): String  实质在调用apply方法 
        println("..() "+bigData(2))             //..() Kaffka
        println() 
        
        
        val data = List('a','b','c','d','e','f')
        //def indices: Range
        println("indices "+ data.indices)                 //indices Range(0, 1, 2, 3, 4, 5)
        //拉栈操作
        println("zip "+ data.indices.zip(data))           //zip Vector((0,a), (1,b), (2,c), (3,d), (4,e), (5,f))
        //将元素和索引 拉栈
        println("zipWithIndex "+ data.zipWithIndex)       //zipWithIndex List((a,0), (b,1), (c,2), (d,3), (e,4), (f,5))
        //toString
        println("toString "+ data.toString())             //toString List(a, b, c, d, e, f)
        //def mkString(start: String, sep: String, end: String): String
        println("mkString "+ data.mkString("[",",","]"))  //mkString [a,b,c,d,e,f]
        //def mkString(sep: String): String  用某个符号对元素进行连接 返回String
        println(""+ data.mkString("     "))               //a     b     c     d     e     f
        //def mkString: String  不采用分隔符连接 直接格式化输出
        println(""+ data.mkString)                        //abcdef
        println()
        
        val buffer = new StringBuilder
        data addString(buffer, "{", "::", "}")
        println(buffer)                                   //{a::b::c::d::e::f}
        println()
    
        //List --> Array
        val array = data.toArray   //val array: Array[Char]
        
        //Array --> List     def toList: List[Char] 
        println("toList " + array.toList )  
        
        
        //将List的内容拷贝到一个数组中
        val new_array = new Array[Char](10)
        //def copyToArray[B >: Char](xs: Array[B], start: Int): Unit
        data.copyToArray(new_array, 3)  
        new_array.foreach(print)       //   abcdef
        println
       
        
        val iterator = data.toIterator //val iterator: Iterator[Char]
        println(iterator.next)         //a
        println(iterator.next)         //b
    }
}