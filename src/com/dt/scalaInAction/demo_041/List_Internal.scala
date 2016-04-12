package com.dt.scalaInAction.demo_041

/**
 * List继承体系实现内幕和方法操作源码揭秘  
 * 
 * List本身是一个抽象类 定义如下：
 * sealed abstract class List[+A] extends AbstractSeq[A] with LinearSeq[A] 
 *                                                       with Product 
 *                                                       with GenericTraversableTemplate[A, List] 
 *                                                       with LinearSeqOptimized[A, List[A]] 
 * 
 * List下的两个重要的子类就是 Nil和  ::
 * 
 * Nil表示空值  定义为一个Cass Object:  case object Nil extends List[Nothing] 
 * 
 * :: 定义 final case class ::[B](private var hd: B, private[scala] var tl: List[B]) extends List[B] 
 * 
 */
object List_Internal {
    def main(args: Array[String]): Unit = {
        val list = List(5, 3, 3, 7, 5)  //这种方式其实是 调用List的伴生对象的apply方法  val list: List[Int]
        val listAny : List[Any] = list  //这是一种"协变"的概念  Int为Any的子类  所以认为List[Int]的具体父类型可以是List[Any]
        println(list.isEmpty)    //false
        println(list.head)       //5
        println(list.tail)       //List(3, 3, 7, 5)
        println(list.length)     //5
        println(list drop 4)     //List(5)
        
        /**
         * drop函数的源码
         * override def drop(n: Int): List[A] = {
              var these = this
              var count = n
              while (!these.isEmpty && count > 0) {
                these = these.tail
                count -= 1
              }
              these
            }
         */
        
        println(list.map(_*2))  //List(10, 6, 6, 14, 10)
        
        /**
         * map源码
         * def map[B, That](f: A => B)(implicit bf: CanBuildFrom[Repr, B, That]): That = {
              def builder = { // extracted to keep method size under 35 bytes, so that it can be JIT-inlined
                val b = bf(repr)
                b.sizeHint(this)
                b
              }
              val b = builder
              for (x <- this) b += f(x)
              b.result
            }
         */
    }
}