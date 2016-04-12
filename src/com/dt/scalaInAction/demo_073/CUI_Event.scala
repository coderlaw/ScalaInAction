package com.dt.scalaInAction.demo_073

import scala.swing._
import scala.swing.event.ButtonClicked
import java.io.File

/**
 * Scala界面和事件处理编程进阶实战
 */
object CUI_Event extends SimpleSwingApplication {
     val fileChooser = new FileChooser(new File("."))
     fileChooser.title = "File Chooser"
     val button = new Button {
         text = "Choose a File from local"
     }
     val label = new Label {
         text = "No any file selected yet"
     }
     val mainPanel = new FlowPanel {
         contents += button
    		 contents += label
     }
     def top = new MainFrame {
         title = "Scala GUI Programing advanced"
         contents = mainPanel
         
         listenTo(button)
         
         reactions += {
             case ButtonClicked(b) => {
                 val result = fileChooser.showOpenDialog(mainPanel)
                 if (result == FileChooser.Result.Approve) {
                     label.text = fileChooser.selectedFile.getPath
                 }
             }
         }
     }
}