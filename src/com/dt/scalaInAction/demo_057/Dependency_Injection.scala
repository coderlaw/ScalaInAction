package com.dt.scalaInAction.demo_057

/**
 * Scala中Dependency Injection实战详解
 * 
 * 在Java实现DI是非常复杂的 在Scala中是通过self types(自身类型)可以轻松的实现DI
 */
trait Logger {
    def log(msg: String)
}
trait Auth {
    auth:Logger =>  //当创建实现类时需要混入这个类型(见demo_056)
    def act(msg: String) {
        log(msg)    //这样写的原因是定义了自身类型(auth:Logger =>)
    }
}
object DI extends Auth with Logger {
    override def log(msg: String) = println(msg)
}
object Dependency_Injection {
    def main(args: Array[String]): Unit = {
        DI.act("I hope you'll like it")
    }
}