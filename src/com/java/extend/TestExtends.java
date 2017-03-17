package com.java.extend;

public class TestExtends {

	public static void main(String[] args) {
		Dog dog = new Dog("black");
		dog.color="yellow";
		System.out.println(dog.color);
	}
}

class Animal{
	String color;//成员变量
	int height;
	
	public Animal(String color){ //color形参
		this.color = color;
	}
}

class Dog extends Animal{

	public Dog(String color) {
		super(color);
		
	}
	
}
