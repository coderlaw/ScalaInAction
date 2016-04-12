package com.dt.scalaInAction.demo_051;

class A {
	public A say(){
		System.out.println(this);
		return this;
	}
}
class B extends A {
	public void shout(){
		
	}
}
public class Test {
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.say());
	}
}
