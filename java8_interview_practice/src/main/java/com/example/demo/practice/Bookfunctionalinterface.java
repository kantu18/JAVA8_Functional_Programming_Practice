package com.example.demo.practice;

@FunctionalInterface
public interface Bookfunctionalinterface {

	String getnames();
	
	//To provide default implementations for all the classes implementing this functional interface
	//or else they can override this default method and provide own implementation.
	
	default String display()
	{
		return "this is display";
	}
	
	//this acts as a utility method and can be used throughout the entire application.
	static String printmethod()
	{
		return "this is a static methods";
	}
}
