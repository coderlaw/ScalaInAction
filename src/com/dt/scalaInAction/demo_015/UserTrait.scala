package com.dt.scalaInAction.demo_015

class Human{
    println("Human")
}
trait TTeacher extends Human{
    println("TTeacher")
    def teach
}
trait PianoPlayer extends Human{
    println("PianoPlayer")
    def playPiano = println("I'm playing piano....")
}
// PianoTeacher的构造顺序是由左往右构造的  scale中不会重复构造 虽然TTeacher PianoPlayer都继承了Human
// scala中会吧extends右边看成一个整体Human with TTeacher with PianoPlayer 也可以通过匿名的方式new出
// val e = new Human with TTeacher with PianoPlayer { 需要复写的方法 }
class PianoTeacher extends Human with TTeacher with PianoPlayer{
    override def teach = println("I'm trianing student...")
}


/**
 * Scala多重继承、多重继承构造器执行顺序及AOP实现
 */
object UserTrait {
    def main(args: Array[String]): Unit = {
        //方法一
        val t1 = new PianoTeacher 
        /**
         * 构造时结构为:
         * Human
         *  TTeacher
         *  PianoPlayer
         */
        t1.playPiano  //row result: I'm playing piano....
        t1.teach      //row result: I'm trianing student...
        println("------------------------------------------")
        
        
        
        //方法二 通过匿名的方式构建PianoTeacher
        val t2 = new Human with TTeacher with PianoPlayer{
            override def teach = println("I'm teaching student...")
        }
        /**
         * 这种方式类似于Java中定义匿名实现接口的类的简化方式
         * new Interface({
         *    @Override
         *    public void fun(){
         *      //to do something
         *    }
         * });
         */
        t2.playPiano  
        t2.teach   
        /** 
         *  结果为:
         *  Human
            TTeacher
            PianoPlayer
            I'm playing piano....
            I'm teaching student...
         */
        
    }
}