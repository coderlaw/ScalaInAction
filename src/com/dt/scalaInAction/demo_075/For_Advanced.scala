package com.dt.scalaInAction.demo_075

/**
 * 模式匹配下的For循环
 */
object For_Advanced {
    def main(args: Array[String]): Unit = {
        println("e.g 1")  //1 2 3 4 5
        for(i <- List(1,2,3,4,5)) {println(i)}
        
        println("e.g 2")  //Flink
        //这里用index绑定"Flink"(@的作用是给"Flink"设置一个别名)
        for(index@"Flink" <- List("Hadoop", "Spark", "Flink")) {println(index)}
        
        println("e.g 3")  //Java
        //采用tuple模式匹配 tuple中第二个值为"Hadoop"的结果
        for((language, "Hadoop") <- Set("Scala"->"Spark", "Java"->"Hadoop")) {println(language)}
        
        println("e.g 4")  //Spark
        //模式匹配可以匹配类型
        for((k, v: Int) <- List(("Spark"->5), ("Hadoop"->"Big Data"))) {println(k)}
    }
}