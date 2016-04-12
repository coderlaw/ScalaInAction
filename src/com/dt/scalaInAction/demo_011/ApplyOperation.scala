package com.dt.scalaInAction.demo_011

class ApplyTest {
    def apply() = {
        println("I am into Spark so much")
    }
    
    def haveATry = println("have a try on apply")
}

object ApplyTest {
    def apply() = {
        println("I am into Scala so much")
        new ApplyTest //通过apply返回伴生类的实例对象 这样可以采用 val a = ApplyTest() 方式返回一个ApplyTest类的实例
    }
}

/**
 * Scala中的apply实战详解
 */
object ApplyOperation {
    def main(args: Array[String]): Unit = {
        val a = ApplyTest()//这种方法会调用伴生对象的apply方法  row result:I am into Scala so much
        //a.haveATry
        
        /*
         * 方法
         * 这种不通过new的方式构建一个数组 采用的就是在类的伴生对象实现apply的方式
         */
        val arr = Array(1, 2, 3, 4, 5)
        
        
        
        
        /*
         * 通过new的方式构建对象  采用a1()可以调用该类的apply的方法
         */
        val a1 = new ApplyTest()
        //a1.haveATry
        a1()  //调用该类的apply的方法  row result:I am into Spark so much
        //println(a1())
    }
}