package com.dt.scalaInAction.demo_066

import scala.actors.Actor

/**
 * Scala并发编程实战初体验及其在Spark源码中的应用解析
 */

/*
 * 基于Scala中Actor的方式实现简单线程需要继承Actor类并复写act方法
 */
object First_Actor extends Actor {
    def act = {
        for(i <- 1 to 10) {
            println("First_Actor Step : " + i)
            Thread.sleep(1000)
        }
    }
}
object Second_Actor extends Actor {
    def act = {
        for(i <- 1 to 10) {
            println("Second_Actor Step : " + i)
            Thread.sleep(2000)
        }
    }
}
object Hello_Actor {
    def main(args: Array[String]): Unit = {
        //调用start方法启动线程
        First_Actor.start
        println("main thread ....")
        Second_Actor.start
    }
  
}