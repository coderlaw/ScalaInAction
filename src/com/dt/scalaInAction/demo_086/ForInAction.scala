package com.dt.scalaInAction.demo_086

/**
 * Scala中For表达式的生成器、定义和过滤器
 */
case class Person(name: String, isMale: Boolean, children: Person*)

object ForInAction {
    def main(args: Array[String]): Unit = {
         val lauren = Person("Lauren", false)
         val rocky = Person("Rocky", true)
         val vivian = Person("Vivian", false, lauren, rocky)
         val persons = List(lauren, rocky, vivian)
         
         //for循环操作列表
         /*val forResult = for (person <- persons; if !person.isMale; child <- person.children)
                         yield(person.name, child.name)*/
         val forResult = for {
                            person <- persons;   //生成器:用于遍历元素
                            name = person.name;  //定义
                            if !person.isMale;   //过滤器
                            child <- person.children //处理
                         }
                         yield(person.name, child.name)
         println(forResult) 
         //List((Vivian,Lauren), (Vivian,Rocky))
         
         //定义两个生成器
         val content = for(x<-List(1,2,3);y<-List("Hadoop","Spark","Flink"))
                       yield(x,y)
         println(content)
         //List((1,Hadoop), (1,Spark), (1,Flink), (2,Hadoop), (2,Spark), (2,Flink), (3,Hadoop), (3,Spark), (3,Flink))

    }
}