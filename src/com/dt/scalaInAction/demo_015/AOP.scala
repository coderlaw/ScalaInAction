package com.dt.scalaInAction.demo_015

trait Action{
    def doAction
}
trait TBeforeAfter extends Action{
     //注意 doAction虽然被复写 但仍然是abstract方法 因为 super.doAction并未实现 所以用abstract关键字标识
     abstract override def doAction {
        println("Initialization")
        super.doAction
        println("Destroyer")
    }
}
class Work extends Action{
    override def doAction = println("Working...")
}
/**
 * Scala中的实现AOP
 */
object AOP {
    def main(args: Array[String]): Unit = {
        val w = new Work with TBeforeAfter
        w.doAction
        /**
         * result:
         *   Initialization
         *   Working...
         *   Destroyer
         */
    }
}