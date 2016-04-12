package com.dt.scalaInAction.demo_071
import scala.swing._
/**
 * Scala界面Panel、Layout实战详解
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
        /*
         * source:
         * override def contents_=(c: Component) {
                super.contents_=(c)
                peer.pack()
           }
         */
        contents = new BoxPanel(Orientation.Vertical){
            contents += button
            contents += label
            border = Swing.EmptyBorder(50, 50, 50, 50)
        }
    }
}