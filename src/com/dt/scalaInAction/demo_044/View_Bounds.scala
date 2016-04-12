package com.dt.scalaInAction.demo_044


/*class Pair_NotPerfect[T <: Comparable[T]](val first: T, val second: T) {
    def bigger = if (first.compareTo(second) > 0) first else second 
}*/

/**
 * 视图界定   <%
 */
class Pair_NotPerfect[T <% Comparable[T]](val first: T, val second: T) {
    def bigger = if (first.compareTo(second) > 0) first else second 
}

/**
 * Ordered视图界定
 * 上面这种方式的12行first.compareTo(second) > 0 通过compareTo来比较 但是不能直观的像数学比较那样清晰
 * Scala提供了Ordered视图界定
 * Ordered在Comparable上提供一些关系型的操作符 < > <= >=等
 */
class Pair_Batter[T <% Ordered[T]](val first: T, val second: T) {
    //这里的 > 是因为Ordered中提供的方法
    def bigger = if (first > second) first else second 
}

/**
 * Scala中View Bounds代码实战及其在Spark中的应用源码解析
 */
object View_Bounds {
    def main(args: Array[String]): Unit = {
        var pair = new Pair_NotPerfect("Spark", "Hadoop")
        println(pair.bigger)  //Spark

        /*
         * 当类型界定为Pair_NotPerfect[T <: Comparable[T]]报错 因为Int本身不是Comparable的子类
         * 
         * 当类型界定为视图界定时 Pair_NotPerfect[T <% Comparable[T]] 就可以正常运行
         * 是因为Int本身不是Comparable的子类型 Scala通过"隐式转换"将Int转换成RichInt 而这个类型是Comparable的子类
         */
        var pairInt = new Pair_NotPerfect(3, 5)  //Int -> RichInt
        println(pairInt.bigger)  //5     
        
        /**
         * 注意：这样定义不是因为String的上界是Ordered[String]
         * 当使用视图界定时 会发生"隐式转换" 把String --> RichString
         * 而RichString是Ordered[RichString]的子类型  RichString中是实现了这样的 < > <= >=等方法
         * 从而真正是让String类型完成视图界定
         */
        var pair_Batter_String = new Pair_Batter("Java", "Scala")
        println(pair_Batter_String.bigger)  //Scala
        
        val pair_Batter_Int = new Pair_Batter(20, 12)
        println(pair_Batter_Int.bigger)     //20
    }
}