package com.dt.scalaInAction.demo_070

import scala.swing._

/**
 * Scala界面GUI编程实战详解
 */
/**
 * Q:函数中没有main入口?
 * A:Hello_GUI继承了scala.swing.SimpleSwingApplication 而SimpleSwingApplication继承了Reactor 在Reactor中有main方法入口
 *   source:
      abstract class SwingApplication extends Reactor {
        ....
        def main(args: Array[String]) = Swing.onEDT { startup(args) }
      }
      
 */
object Hello_GUI extends SimpleSwingApplication{
    /*
     * MainFrame是顶级容器
     * SimpleSwingApplication需要复写top方法返回类型为Frame类型
     * source:   def top: Frame
     */
    def top = new MainFrame {
        title = "Hello GUI"
        contents = new Button {
            text = "Scale => Spark"
        }
    }
}