package com.dt.scalaInAction.demo_048

/**
 * Scala类型约束代码实战及其在Spark中的应用源码解析
 * 
 * A =:= B 表示A类型等同于B类型
 * A <:< B 表示A类型是B类型的子类型
 */
object Type_Contraints {
    def main(args: Array[String]): Unit = {
        
        def rocky[T](i: T)(implicit ev: T <:< java.io.Serializable) {
            println(ev)   //<function1>
            println("Life is short, you need Spark!")
        }
        rocky("spark")
        //rocky(100) error:Cannot prove that Int <:< java.io.Serializable.
    }
}