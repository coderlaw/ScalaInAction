package com.dt.scalaInAction.demo_072
import scala.swing._
import scala.swing.event.ButtonClicked
/**
 * Scala界面事件处理编程实战详解
 */
object CUI_Panel_Layout extends SimpleSwingApplication { 
    def top = new MainFrame {
        title = "Second GUI"
        val button = new Button {
           text = "Scala"
        }
        var label = new Label {
           text = "Here is Spark!!!"
        }
        //定义容器内部组件
        contents = new BoxPanel(Orientation.Vertical){
            contents += button
            contents += label
            border = Swing.EmptyBorder(50, 50, 50, 50)
        }
        
        /**
         * Source:
         *  trait Reactor {
              val reactions: Reactions = new Reactions.Impl
              def listenTo(ps: Publisher*) = for (p <- ps) p.subscribe(reactions)
              def deafTo(ps: Publisher*) = for (p <- ps) p.unsubscribe(reactions)
            }
         */
        //事件监听
        listenTo(button)
        var clicks = 0
        //reactions方法是用于对事件进行处理 +=函数添加对应的事件处理 -=函数除去对应的事件处理
        /**
         * source:
         * abstract class Reactions extends Reactions.Reaction {
              def += (r: Reactions.Reaction): this.type
              def -= (r: Reactions.Reaction): this.type
          }
         */
        reactions += {
            //通过模式匹配出合适的事件源 可以匹配多种事件源
            case ButtonClicked(button) => {
                clicks += 1
                label.text = "Clicked" + clicks + " times"
            } 
        }
        
    }
}