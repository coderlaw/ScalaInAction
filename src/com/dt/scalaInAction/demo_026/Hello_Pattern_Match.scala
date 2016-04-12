package com.dt.scalaInAction.demo_026

/**
 * Scala中模式匹配入门实战详解
 */
object Hello_Pattern_Match {
    def main(args: Array[String]): Unit = {
        //1
        val data = 30
        data match {
            case 1 => println("First")   //这是函数定义与实现的方式  =>左侧可以是变量和条件表达式 =>右侧可以是函数的实现
            case 2 => println("Second")
            case _ => println("Not know number")  //case _ 代表所有的其它情况
        }   //row result:Not know number
        //Scala中的模式匹配和Java中switch case相似 
        //其区别在于scala在每个匹配完成之后自动break跳出不在往下匹配  等价于Java中的switch ... case : ... ; break;
        
        
        //2
        val result = data match {
            case i if i == 1 => "The First"   //i 和 number 为val 用于接收传进来的data 他们在声明的时候会被实例化为data的内容
            case number if number == 2 => "Second"  
            case _ => "Not Know Number"
        }
        println("result="+result)   //row result:Not know number
        
        //3
        "Spark !".foreach {
            c => println(
                c match {
                  case ' ' => "space"
                  case ch => "Char:" + ch
                }
            )
        }
        /**
         *  Char:S
            Char:p
            Char:a
            Char:r
            Char:k
            space
            Char:!
         */
    }
}