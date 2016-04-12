package com.dt.scalaInAction.demo_087

/**
 * Scala中使用For表达式做查询
 */
case class Book(title: String, author: List[String])
object For_Query {
    def main(args: Array[String]): Unit = {
        val books = List(
            Book("Structure and Interpretation", List("Abelson,Harold", "Sussman")),
            Book("Principles of Compiler Design", List("Aho,Alfred", "Ullman,Jeffery")),
            Book("Programming in Modula-2", List("Wirth,Niklaus")),
            Book("Introduction to Functional Programming", List("Bird,Richard")),
            Book("The Java Language Specification", List("Gosling,James", "Joy,Bill", "Steele,Guy", "Bracha,Gilad"))
        )
        
        val result = for(b <-books; a<-b.author; if a startsWith "Gosling") yield b.title
        println(result)  //result: List(The Java Language Specification)
        
        val result1 = for(b <-books; if(b.title indexOf "Programming")!= -1 ) yield b.title
        println(result1)  //result: List(Programming in Modula-2, Introduction to Functional Programming)
    }
}