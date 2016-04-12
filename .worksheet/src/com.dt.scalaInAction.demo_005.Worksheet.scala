package com.dt.scalaInAction.demo_005

object Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(101); 
  println("Welcome to the Scala worksheet");$skip(52); 
   //定义长度为10的Int型数组
	 val nums = new Array[Int](10);System.out.println("""nums  : Array[Int] = """ + $show(nums ));$skip(54); 
	 //定义长度为10的String型数组
	 val a = new Array[String](10);System.out.println("""a  : Array[String] = """ + $show(a ));$skip(45); 
	 //静态定义方式
	 val s = Array("Hello", "World");System.out.println("""s  : Array[String] = """ + $show(s ));$skip(34); 
	 
	 //修改数组中的值
	 s(0) = "Goodbye"}
}
