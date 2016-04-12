package com.dt.scalaInAction.demo_076

/**
 * 模式匹配下的赋值语句
 */
object Assinment_Internals {
    def main(args: Array[String]): Unit = {
        //@表示这是别名 a@b表示a设置为b的别名 背后采用模式匹配完成
        val a@b = 1000
        println("a="+a+",b="+b)   //a=1000,b=1000
        
        //用元祖的方式给两个变量同时赋值
        val (c, d) = (1000, 2000)
        //val (e, F) = (1000, 2000) //编译出错 一般而言在模式匹配时为小写 F大写 编译器会吧F作为常量进行匹配(找不到F)
        
        //采用数组进行成员匹配
        val Array(g,h) = Array(1000, 2000)
        //val Array(J,K) = Array(1000, 2000)  //编译出错 
        
        //object Test { val 1 = 1}   //1=1 匹配成功
        object Test { val 1 = 2}     //1=2匹配失败 但是没有编译报错？
    }
}