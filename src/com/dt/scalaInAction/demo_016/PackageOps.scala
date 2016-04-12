package com.dt.scalaInAction.demo_016

package com.scala.spark

/**
 * Scala中包的定义、包对象、包的引用、包的隐式引用
 */
object PackageOps {}

/**
 * Scala包的隐式引用
 */
//import java.lang._   //java.lang包的所有内容  _表示导入包中的所有的内容 等价于Java中的import java.lang.*
//import scala._       //scala包中所有的内容
//import Predef._      //Predef对象中的所有的内容


/**
 * 引入内容方式
 */
//import java.awt.{Color, Font} //采用{}的方式来引入包中的部分内容
//import java.util.{HashMap=>JavaHashMap} //解决scala和Java包命名的冲突 为java.util.{HashMap取别名
//import scala.{StringBuilder=>_} //采用=>_ 占位符的方式屏蔽内容 这样就无法访问scala包下的StringBuilder这个内容


/*
 * 包对象
 * 因为在包中不可以定义成员和方法 所以可以将一些需要得成员和方法定义在包对象中 便于包的类可以访问
 * 作用:包中所有的类就可以访问包对象中所有的成员和方法
 */
//可以在包中定义包对象  package object packageName
package object people{
    val defaultName = "Scala"
}
//包中所有的
package people {
    //val defaultName = "Scala"  //包中不可以定义成员和方法
    class people {
        var name = defaultName  //访问包对象中的成员和方法
    }
}




class PackageOps{}
//包的定义可以采用这种链式的定义方式
package spark.navigation {
    abstract class Navigation {
        def act
    }
    package tests{
        //该类是在 spark.navigation.tests包里
        class NavigationSuite
    }
    package impl {
       class Action extends Navigation {
           def act = println("Action")
       }
    }
}
package hadoop{
    package navigation {
        class Navigation
    }
    package launch{
        class Booster {
            //val nav = new hadoop.navigation.Navigation 可以写全包名
          val nav = new navigation.Navigation
        }
    }
}

