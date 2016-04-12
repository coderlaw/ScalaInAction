package com.dt.scalaInAction.demo_053

/**
 * Scala中结构类型实战详解
 * 
 * 结构类型不关心传入的类型 只关心传入的对象具有某一种行为
 */
class Structural {
    def open() = println("A class instance Opened")
}

object Structural_Type {
    def main(args: Array[String]): Unit = {
        init(new { def open()=println("Opened")})
        
        /*
         * type关键字的作用是把"="右边的内容取一个别名  
         */
        type X = {def open():Unit}

        def init(res: X) = res.open
        init(new {def open(){println("Opened again")}})
        
        /**
         * 定义一个单例对象
         */
        object A {
            def open(){
                println("A single object Opened")
            }
        }
        init(A)
        
        val structual = new Structural
        init(structual)
        
    }
    
    /**
     * 注意:这个函数的定义来看， 并不关心传入对象类型是什么，只关心传入对象必须具有open方法即可
     */
    def init(res: {def open():Unit}) {
    	res.open()
    }
    
}