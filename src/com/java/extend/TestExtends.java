package com.java.extend;

public class TestExtends {

	public static void main(String[] args) {
		Dog dog = new Dog("black");
		dog.color="yellow";
		System.out.println(dog.color);
	}
}

class Animal{
	String color;//��Ա����
	int height;
	
	public Animal(String color){ //color�β�
		this.color = color;
	}
}

class Dog extends Animal{

	public Dog(String color) {
		super(color);
		
	}
	
}
