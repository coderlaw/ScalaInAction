package com.dt.scalaInAction.demo_019

/**
 * Scala中的正则表达式、与模式匹配结合的的Reg代码实战
 */
object RegExpOps {
    def main(args: Array[String]): Unit = {
        val regex = """([0-9]+) ([a-z]+)""".r  //def r: Regex
        val numPattern = "[0-9]+".r
        val numberPattern = """\s+[0-9]+\s+""".r
        
        //findAllIn方法返回编译所有匹配的迭代器
        for(matchString <- numberPattern.findAllIn("99345 Scala, 22298 Spark")) println(matchString)
        
        //找到首个匹配项
        println(numberPattern.findFirstIn("99ss java, 222 hadoop"))
        
        val numitemPattern = """([0-9]+) ([a-z]+)""".r
        val numitemPattern(num, item) = "99 hadoop"
        
        val line = "93459 spark"
        /**
         * 模式匹配
         */
        line match {
          case numitemPattern(num, blog) => println(num + "\t" + blog)
          case _ => println("That's all")
        }
        
    }
}