package com.dt.scalaInAction.demo_039

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.Queue
//import scala.collection.mutable.Queue

/**
 * ListBuffer、ArrayBuffer、Queue、Stack操作代码实战
 */
object ListBuffer_ArrayBuffer_Queue_Stack_Ops {
    def main(args: Array[String]): Unit = {
      
        //ListBuffer
        val listBuffer = new ListBuffer[Int]() //scala.collection.mutable.ListBuffer
        //追加元素  +  def += (x: A): this.type
        listBuffer += 1
        listBuffer += 2
        println(listBuffer)   //ListBuffer(1, 2)

        //ArrayBuffer
        val arrayBuffer = new ArrayBuffer[Int]() //scala.collection.mutable.ArrayBuffer
        //追加元素   + def +=(elem: A): this.type  用法和ListBuffer类似
        arrayBuffer += 1
        arrayBuffer += 2
        println(arrayBuffer) //ArrayBuffer(1, 2)
        
        //scala.collection.immutable.Queue
        val queue = Queue[Int]()  //scala.collection.immutable.Queue   这是一个不可变的队列
        //入队列操作 enqueue
        val queue1 = queue.enqueue(1)
        println(queue1)   //Queue(1)
        //enqueue 一个集合
        val queue2 = queue.enqueue(List(2, 3, 4, 5))      
        println(queue2)   //Queue(2, 3, 4, 5)
        //出队列操作 dequeue  def dequeue: (A, Queue[A])
        val (element, left) = queue2.dequeue 
        println("element="+element) //element=2
        println("left="+left)       //left=Queue(3, 4, 5)
        
        //scala.collection.mutable.Queue
        val queueBuffer = scala.collection.mutable.Queue[String]()
        //入队 +
        queueBuffer += "a"
        //入队 集合 ++
        queueBuffer ++= List("b", "c")
        println("queueBuffer="+queueBuffer); //queueBuffer=Queue(a, b, c)
        //出队列  def dequeue(): A  直接返回出队元素
        //注意：与scala.collection.immutable.Queue的dequeue不同 immutable.Queue的dequeue返回一个元祖(出队的元素, 改变之后的队列)
        println("dequeue return"+queueBuffer.dequeue) //a
        println(queueBuffer) //Queue(b, c)

        //mutable Stack
        val stack = new scala.collection.mutable.Stack[Int]
        //入栈
        stack.push(1)
        stack.push(2)
        stack.push(3)
        println(stack)      //Stack(3, 2, 1)
        //top 去除栈顶元素 但不做出栈操作
        println(stack.top)  //3
        println(stack)      //Stack(3, 2, 1)
        //pop 去除栈顶元素 但做出栈操作
        println(stack.pop)  //3
        println(stack)      //Stack(2, 1)
        
        
    
    }
}