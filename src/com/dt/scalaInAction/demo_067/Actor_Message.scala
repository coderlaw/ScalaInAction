package com.dt.scalaInAction.demo_067

import scala.actors.Actor._
import scala.actors.Actor

/**
 * Scala并发编程匿名Actor、消息传递、偏函数实战解析及其在Spark源码中的应用解析
 */

object Message_Actor extends Actor {
    def act = {
        while(true) {
            /*
             * receive函数用于接收消息
             * receive方法会先调用isDefinedAt方法
             * 只有当isDefinedAt返回true时才会将消息传递给receive偏函数的apply方法(receive偏函数会去"收件箱"中的查找isDefinedAt返回true的消息)
             * (也就是如果"邮箱"中没有isDefinedAt返回true的这样的消息 那么receive所在的这个Actor就会一直处于阻塞状态)
             * 而这个apply才会真正处理这个消息
             * 
             * 注意:receive只会处理case模式匹配的消息 如果没有找到相关的匹配就会忽略该消息
             */
            receive {
              //接收匹配的消息
              case msg => println("Message content from ibox: " + msg)
            }
        }
    }
}

object Actor_Message {
    def main(args: Array[String]): Unit = {
        /**
         * 匿名方式定义Actor
         * 导入scala.actors.Actor类中actor 
         * source define:
         *    def actor(body: => Unit): Actor = {
                  val a = new Actor {
                    def act() = body
                    override final val scheduler: IScheduler = parentScheduler
                  }
                  a.start()
                  a
              }
         */
        val actor_Meaasge = actor{
            //actor不断循环自己的"邮箱"
            while(true) {
                //receive 偏函数由于接收邮箱
                receive {
                  //通过模式匹配 接收消息
                  case msg => println("Message content from ibox: " + msg)
                }
            }
        }
        
         val double_Meaasge = actor{
            while(true) {
                receive {
                  case msg: Double => println("Double Number from ibox: " + msg)
                  case _ => println("Something Unknow")
                }
            }
        }
        
        // ! 函数用于发消息
        /**
         *  override def !(msg: Any) {
         *    send(msg, Actor.rawSelf(scheduler))
         *  }
         */
        actor_Meaasge ! "Spark"
        double_Meaasge ! Math.PI
        //由于double_Meaasge的receive偏函数中没有匹配的消息 造成消息没有响应  需要增加匹配的消息响应即可
        double_Meaasge ! "Hadoop" 
        /**
         *  Message content from ibox: Spark
            Double Number from ibox: 3.141592653589793
            Something Unknow
         */
        
        Message_Actor.start
        Message_Actor ! "Hadoop"
        //Message content from ibox: Hadoop
        
    }
}