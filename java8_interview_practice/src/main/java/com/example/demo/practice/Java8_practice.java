package com.example.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.comparator.Comparators;

public class Java8_practice {

	public static void main(String args[])
	{
		//1) Find the Second largest element
		int arr[]= {2,1,35,34,21,66,27,1,2,44,75,18,28,18,28,75};
		
		Integer anssecond_largest = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(anssecond_largest);
		
		//Second Smallest
		Integer anssecond_smallest = Arrays.stream(arr).boxed().distinct().sorted(Comparator.naturalOrder()).skip(1).findFirst().get();
		System.out.println(anssecond_smallest);
		
		//Non duplicating string characters
		String test="adnmbsdmnsajkqwaaadd";
		List<String> collect = Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
					.entrySet().stream().filter(mapres -> mapres.getValue()<=1).map(res -> res.getKey()).collect(Collectors.toList());
		
		System.out.println(collect);
		
		//Find the common elements in both the arrays
		int firstarr[]= {1,2,3,4,5};
		int secarr[]= {3,4,5,1,2};
		List<Integer> firstcollect = Arrays.stream(firstarr).boxed().collect(Collectors.toList());
		
		List<Integer> seccollect = Arrays.stream(secarr).boxed().collect(Collectors.toList());
		
		List<Integer> answer = firstcollect.stream().filter(res -> seccollect.contains(res)).collect(Collectors.toList());
		
		System.out.println(answer);
		
		//Print longest String and its length
		String testarray[]= {"salkdlskaj","asjdl","qiw","qwliw","lqwj"};
		
		String s1 = Arrays.stream(testarray).reduce((str1, str2) -> str1.length() > str2.length()? str1:str2).get();
		System.out.println(s1);
		
		int orElse = Arrays.stream(testarray).mapToInt(str -> str.length()).max().orElse(0);
		System.out.println(orElse);
		
		//Print the duplicated elements
		int duparr[]= {1,2,3,2,4,2,4,5,6,7,8,9,6,1,5};
		
		List<Integer> mapres = Arrays.stream(duparr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
							.entrySet().stream().filter(res -> res.getValue()>1).map(result-> result.getKey()).collect(Collectors.toList());
		System.out.println(mapres);
	
		
		Employee obj=new Employee("Snehasis","USA",100000,"SDE",7200);
		Employee obj1=new Employee("Kai","USA",90000,"SDE",7900);
		Employee obj2=new Employee("Ray","Tokyo",40000,"DEV",2200);
		Employee obj3=new Employee("Tyson","Japan",880000,"DEV",7200);
		Employee obj4=new Employee("Jinga","Japan",50000,"SDE",4200);
		Employee obj5=new Employee("Rayuga","UK",90000,"TESTING",4200);
		Employee obj6=new Employee("Max","AMERICA",30,"TESTING",5200);
		Employee obj7=new Employee("Kenny","UK",900000,"DEV",4200);
		Employee obj8=new Employee("Leon","Tokyo",800000,"QA",7000);
		Employee obj9=new Employee("Messi","Argentina",700000,"QA",7200);
		Employee obj11=new Employee("Pedri","Spain",340000,"Prod",3200);
		Employee obj10=new Employee("Gavi","Spain",20000,"Prod",7200);
				
		List<Employee> emplist=new ArrayList<Employee>();
		emplist.add(obj);
		emplist.add(obj1);emplist.add(obj2);emplist.add(obj3);emplist.add(obj4);emplist.add(obj5);emplist.add(obj6);
		emplist.add(obj7);emplist.add(obj8);emplist.add(obj9);emplist.add(obj11);emplist.add(obj10);
		
		
		//MAximum salary from each address
		Comparator<Employee> empcom= Comparator.comparing(Employee::getAddress).reversed();
		
		List<Entry<Double, Optional<Employee>>> collect2 = emplist.stream().collect(Collectors.groupingBy(emp -> emp.getSalary(),
				Collectors.reducing(BinaryOperator.maxBy(empcom)))).entrySet().stream().collect(Collectors.toList());
	
		System.out.println(collect2);
		
		
		//Max and Min salary from employee
		int maxsal = emplist.stream().mapToInt(res -> res.getBonus()).max().orElse(0);
		
		System.out.println(maxsal);
		
		
		Comparator<Employee> empobjc= Comparator.comparing(Employee::getSalary).reversed();
		
		 String maxsalaryamongall = emplist.stream().collect(Collectors.groupingBy(em -> em.getName(),
				Collectors.reducing(BinaryOperator.maxBy(empobjc)))).entrySet().stream().map(emf -> emf.getKey()).findFirst().get();
			
		 System.out.println(maxsalaryamongall);
	}			
	
}
