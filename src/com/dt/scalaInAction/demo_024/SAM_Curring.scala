package com.dt.scalaInAction.demo_024

import javax.swing.JFrame
import javax.swing.JButton
import java.awt.event.ActionListener
import java.awt.event.ActionEvent


/**
 * Scala中SAM转换实战详解
 */
object SAM_Curring {
    def main(args: Array[String]): Unit = {
        var data = 0
        val frame = new JFrame("SAM Testing")
        val jButton = new JButton("Counter")
        /*
         * Java中实现a按钮接听 
         * 但事实上我们并不关心 监听的ActionListener和实现事件处理的函数actionPerformed 以及事件对象ActionEvent
         */
//        jButton.addActionListener(new ActionListener{
//            override def actionPerformed(event: ActionEvent){
//              data += 1
//              println("data="+data)
//            }
//        })
        
        /*
         * Scala实现监听
         */
        implicit def convertedAction(action: (ActionEvent) => Unit) =
           new ActionListener {
               override def actionPerformed(event: ActionEvent) {action(event) }
           }
        
        jButton.addActionListener((event: ActionEvent) => {data += 1;println("data="+data)})
        
        
        
        frame.setContentPane(jButton)
        frame.pack()
        frame.setVisible(true)
        
        
    }
}