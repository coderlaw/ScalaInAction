package com.dt.scalaInAction.demo_089

/**
 * Scala中使用For表达式实现map、flatMap、filter
 */
object For_Advanced {
    def main(args: Array[String]): Unit = {}
    
    def map[A, B](list: List[A], f: A => B): List[B] = 
        for(e <- list) yield f(e)
    
    def flatMap[A, B](list: List[A], f: A => List[B]): List[B] =
        for(x <- list; y <- f(x)) yield y
        
    def filter[A](list: List[A], f: A => Boolean): List[A] = 
        for(e <- list; if f(e)) yield e
}