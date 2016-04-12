package com.dt.scalaInAction.demo_069

import scala.actors.Actor
import scala.actors.Actor._
import java.net.InetAddress
import java.net.UnknownHostException

/**
 * Scala并发编程react、loop代码实战详解
 */
case class Net(name: String, actor: Actor)

object NameResolver extends Actor {
    def act = {
        //线程的重用
    		/*react {
        		case Net(name, actor) => 
        		    actor ! getIp(name)
        		    act
        		case "EXIT" => println("Name resolver exiting.")
        		case msg =>
        		    println("Unhandler message : " + msg)
        		    act
    		}*/
      
      loop {
          react {
            case Net(name, actor) =>
                sender ! getIp(name)
            case msg =>
                println("Unhandled message : " + msg)
          }
      }
        
        
    }
    
    def getIp(name: String) : Option[InetAddress] = {
         try {
             println(InetAddress.getByName(name))
             Some(InetAddress.getByName(name))
         } catch {
           case _: UnknownHostException => None
         }
    }
}
object Actor_More_Effective {
    def main(args: Array[String]): Unit = {
        NameResolver.start
        NameResolver ! Net("www.baidu.com", self)
        
        println(self.receiveWithin(1000){case x => x})
    }
}