package com.dt.scalaInAction.demo_068

import scala.actors.Actor
import scala.actors.Actor._
/**
 * Scala并发编程原生线程Actor、Cass Class下的消息传递和偏函数实战解析及其在Spark中的应用源码解析
 */
//这里定义一个caseclass作为一个消息体
case class Person(val name: String, val age: Int)
class HelloActor extends Actor {
    def act = {
        while(true) {
            receive {
                //用case Class进行模式匹配消息
                case Person(name, age) => {
                    println("Name:"+name+",Age:"+age)
                    //向主线程(发送者)发消息
                    sender ! "Echo!!!"
                }
                case _ => println("Something else....")
            }
        }
    }
}
object Actor_With_CaseClass {
    def main(args: Array[String]): Unit = {
        val hiActor = new HelloActor
        hiActor.start
        hiActor ! Person("Spark", 6)
        
        //让主线程接受消息(把主线程作为Actor使用) 默认是柱塞的
        self.receive{case msg => println("self.receive mseeage:"+msg)}
        //receiveWithin偏函数 参数设置是超时时间
        //self.receiveWithin(1){case msg => println("self.receive mseeage:"+msg)}
    }
}