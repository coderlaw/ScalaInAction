package com.dt.scalaInAction.demo_054

/**
 * Scala中复合类型实战详解
 */
trait Compound_Type1;
trait Compound_Type2;
class Compound_Type extends Compound_Type1 with Compound_Type2

object Compound_Type {
    //这里的方法传入的类型要求是复合类型 A with B 也就是说传入的类型即时A也是B
    def compound_Type(x: Compound_Type1 with Compound_Type2) = {
        println("Compound Type in global method")
    }
    def main(args: Array[String]): Unit = {
        compound_Type(new Compound_Type1 with Compound_Type2)   //Compound Type in global method
        
        object compound_Type_object extends Compound_Type1 with Compound_Type2
        compound_Type(compound_Type_object)                     //Compound Type in global method
        
        //采用别名定义
        type compound_Type_Alias = Compound_Type1 with Compound_Type2
        def compound_Type_Loacl(x: compound_Type_Alias) = println("Compound Type in local method")
    
        val compound_Type_Class = new Compound_Type
        compound_Type_Loacl(compound_Type_Class)                //Compound Type in local method
        
        /* 
         *  这里定义了一个复合类型+结构类型
         *  Compound_Type1 with Compound_Type2 是复合类型
         *  {def init():Unit} 是定义了一个结构类型 要求传入的类型必须具有init的方法
         *  
         *  
         *  type 用于定义特别复杂的类型 (比如在某些需要的情况下定义复合类型、结构类型)
         */
        type Scala = Compound_Type1 with Compound_Type2{def init():Unit}
    }
}