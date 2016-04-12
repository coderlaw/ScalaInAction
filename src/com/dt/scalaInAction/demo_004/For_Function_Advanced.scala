package com.dt.scalaInAction.demo_004

/**
 * For与Function进阶实战
 */
object For_Function_Advanced {
    def main(args: Array[String]): Unit = {
        for(i <- 1.to(2); j <- 1.to(2)) print((100*i+j)+" ")    //101 102 201 202
        println
        
        /**
         * for 表达式中的判断 可以加入复杂的条件表达式(重要)
         */
        for(i <- 1.to(2); j <- 1.to(2) if i != j) print((100*i+j)+" ")    //102 201
        println
      
      
      
      
      
      /**
       * 重要:在Scala中 函数时有值的 "="右边是对 怎么对函数进行计算   所以函数是可以作为参数进行传递的
       */
      def addA(x : Int) = x + 100       //def addA(x: Int): Int
      println("The result from a function is : " + addA(1))
      /**
       * "="的右侧其实是一个函数 (x : Int) => x + 100  这个函数没有名字是一个 匿名函数
       */
      val add = (x : Int) => x + 100    //val add: Int => Int
      println("The result from a val is : " + add(2))
      
      
      
      /**
       * 递归调用  在Scala中必须指明函数的返回值
       */
      def fac(n : Int) : Int = if(n <= 0) 1 else n * fac(n-1)
      println("The result from a fac is : " + fac(10))
      
      
      
      
      /**
       * 函数的默认值  param:type=vlaue
       */
      def combine(content : String,
                  left    : String = "{",
                  right   : String = "}") = left + content + right
      println("The result from a combine is : " + combine("I love you"))
      println("The result from a combine is : " + combine("I love you", "(^", "^)"))
      
      
      
      
      /**
       * 函数的参数是可变的 定义方式param:type*
       */
      def plus(x: Int*) = {
        var result = 0
        for (e <- x) result += e
        result
      }
      println("The result from a plus is : " + plus(1))
      println("The result from a plus is : " + plus(1,2,3,4,5))
      
      
    }
}