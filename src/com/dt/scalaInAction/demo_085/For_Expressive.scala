package com.dt.scalaInAction.demo_085

case class Person(name: String, isMale: Boolean, children: Person*)

/**
 * Scala中For表达式的强大表现力实战
 */
object For_Expressive {
    def main(args: Array[String]): Unit = {
       val lauren = Person("Lauren", false)
       val rocky = Person("Rocky", true)
       val vivian = Person("Vivian", false, lauren, rocky)
       val persons = List(lauren, rocky, vivian)
       
       //高阶函数操作列表
       val result = persons.filter(person => !person.isMale)  //def filter(p: Person => Boolean): List[Person]
                           .flatMap(person =>(person.children map (child=>(person.name, child.name) ) ) )
       println(result) //List((Vivian,Lauren), (Vivian,Rocky))

       //for循环操作列表
       val forResult = for (person <- persons; if !person.isMale; child <- person.children)
                       yield(person.name, child.name)
       println(forResult) //List((Vivian,Lauren), (Vivian,Rocky))
    }
}