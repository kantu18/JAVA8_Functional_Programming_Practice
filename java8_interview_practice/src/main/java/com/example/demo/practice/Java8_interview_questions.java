package com.example.demo.practice;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8_interview_questions {

	public static void main(String args[])
	{
		
		/* 1) print the occurrences of each character in a string*/
		
		String test="aasnehasisjklozxicnmzxu";
		
		//Splitting each element of string 
		String testarray[]=test.split("");
		
		//convert string to array
		//Arrays.toString(testarray);
		
		 Map<String, Long> map= Arrays.stream(test.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.print(map);
		
		/* 2) print the duplicate elements of a given string*/

		List<String> collect = Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
					.entrySet().stream().filter(mapres -> mapres.getValue()>1).map(finalres -> finalres.getKey())
					.collect(Collectors.toList());
		
		System.out.print("\n");
		System.out.print(collect);
		
		/* 3) print the vowels and non duplicating elements*/
		
		List<String> finalres= Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
						.entrySet().stream().filter(cous-> cous.getValue()<=1 && cous.toString().contains("a")||
									cous.toString().contains("e")|| cous.toString().contains("i")|| cous.toString().contains("o")||
								cous.toString().contains("u")).map(result -> result.getKey()).collect(Collectors.toList());
		
		System.out.print("\n");
		System.out.print(finalres);
		
		
		/* 4) print the first repeating and non-repeating elements of a given string*/
		//Need to use Lined hashmap as original map does not store the sequence insert order for the converted string array
		
		//First duplicated/repeated element in string
		String stres= Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(),
							LinkedHashMap::new,Collectors.counting()))
						.entrySet().stream().filter(mapres -> mapres.getValue()>1).findFirst().get().getKey();
		
		//First non-repeating element in string
		String stres1= Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(),
				LinkedHashMap::new,Collectors.counting()))
			.entrySet().stream().filter(mapres -> mapres.getValue()<=1).findFirst().get().getKey();

		System.out.print("\n");
		System.out.println(stres);
		System.out.println(stres1);
		
		/* 5) print the second and third largest& smallest element in an array */
		
		int arr[]= {10,23,83,12,95,83,92,99,21,18,21,23,88,26};
		
		//Removing all duplicate elements from integer array (alongside autoboxing int to integer)
		//Without autoboxing comparator will not work
	  List<Integer> intresult = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	  			.entrySet().stream().filter(mapint -> mapint.getValue() ==1).map(mapres -> mapres.getKey())
	  			.collect(Collectors.toList());
		
	    Integer anssecondlarge= intresult.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	  
	    Integer ansthirdlarge= intresult.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
		 
	    Integer anssecondsmall= intresult.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().get();
		
	    Integer ansthirdsmall= intresult.stream().sorted(Comparator.naturalOrder()).skip(2).findFirst().get();
		
	  	System.out.print("\n");
		System.out.println(intresult);
		System.out.println("second largest element is:" +anssecondlarge);
		System.out.println("third largest element is:" +ansthirdlarge);
		System.out.println("second smallest element is:" +anssecondsmall);
		System.out.println("third smallest element is:" +ansthirdsmall);
		
		/* 6) print the longest& smallest substring inside a string */
		
		String longeststring []= {"kai", "ray", "tyson", "snehasis", "rayuga"}; 
		
		String finallongstring = Arrays.stream(longeststring).reduce((bay1, bay2) -> bay1.length() > bay2.length()?bay1:bay2).get();
		
		String finalsmalleststring = Arrays.stream(longeststring).reduce((bay1,bay2)-> bay1.length() < bay2.length()? bay1:bay2).get();
		
		System.out.print("\n");
		System.out.println(finallongstring);
		System.out.println(finalsmalleststring);
		
		/* 7) print the elements that startswith with 1*/
		int integerarr[]= {1,18,188,23,21,4,6,8,32,11};
		
		List<String> finalconvertlist = Arrays.stream(integerarr).boxed().map(convert -> convert.toString())
				.filter(check -> check.startsWith("1"))
				.collect(Collectors.toList());
	
		System.out.print("\n");
		System.out.println(finalconvertlist);


		//reverse a string
		String reversed = IntStream.range(0, test.length())  // Create an index stream
				.mapToObj(i -> test.charAt(test.length() - 1 - i))  // Fetch characters in reverse order
				.map(String::valueOf)  // Convert characters to String
				.collect(Collectors.joining());  // Join to form reversed string

		// Print reversed string
		System.out.println("Reversed String: " + reversed);

		//Swap second and second last character of string
		int secondIndexstr = 1;
		int secondLastIndexstr = test.length() - 2;

		// Swap second and second-last character using Streams
		String swapped = IntStream.range(0, test.length())
				.mapToObj(i -> i == secondIndexstr ? String.valueOf(test.charAt(secondLastIndexstr)) :  // Replace second with second-last
						i == secondLastIndexstr ? String.valueOf(test.charAt(secondIndexstr)) :  // Replace second-last with second
								String.valueOf(test.charAt(i)))  // Keep other characters unchanged
				.collect(Collectors.joining());

		/* 8) Filter out the highest and lowest salary for employees in each department*/
		
		Employee obj=new Employee("Snehasis","USA",100000,"SDE",7200);
		Employee obj1=new Employee("Kai","USA",90000,"SDE",7900);
		Employee obj2=new Employee("Ray","Tokyo",40000,"DEV",2200);
		Employee obj3=new Employee("Tyson","Japan",880000,"DEV",7200);
		Employee obj4=new Employee("Jinga","Japan",50000,"SDE",4200);
		Employee obj5=new Employee("Rayuga","UK",90000,"TESTING",4200);
		Employee obj6=new Employee("Max","AMERICA",30000,"TESTING",5200);
		Employee obj7=new Employee("Kenny","UK",900000,"DEV",4200);
		Employee obj8=new Employee("Leon","Tokyo",800000,"QA",7000);
		Employee obj9=new Employee("Messi","Argentina",700000,"QA",7200);
		Employee obj11=new Employee("Pedri","Spain",340000,"Prod",3200);
		Employee obj10=new Employee("Gavi","Spain",20000,"Prod",7200);
		
		List<Employee> emplist=new ArrayList<Employee>();
		emplist.add(obj);
		emplist.add(obj1);emplist.add(obj2);emplist.add(obj3);emplist.add(obj4);emplist.add(obj5);emplist.add(obj6);
		emplist.add(obj7);emplist.add(obj8);emplist.add(obj9);emplist.add(obj11);emplist.add(obj10);
		
		
		//Highest Salary from each department
		Comparator<Employee> compobj=Comparator.comparing(Employee::getSalary);
		Map<String, Optional<Employee>> collect2 = emplist.stream().collect(Collectors.groupingBy(emp -> emp.getDept(),
						Collectors.reducing(BinaryOperator.maxBy(compobj))));
		
		
		//Lowest Salary from each department
		Comparator<Employee> comobj1=Comparator.comparing(Employee::getSalary).reversed();
		Map<String, Optional<Employee>> collect3 = emplist.stream().collect(Collectors.groupingBy(emp -> emp.getDept(),
				Collectors.reducing(BinaryOperator.maxBy(comobj1))));

		//Find the total salary paid to employees in each department.
		Map<String, Integer> totalSalaryByDept = emplist.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.summingInt(Employee::getSalary)));

		System.out.println("Total salary by department: " + totalSalaryByDept);
		
		HashMap<String, Integer> mapobj=new HashMap<String, Integer>();
		mapobj.put("Snehasis", 1);
		mapobj.put("rahul", 2);
		mapobj.put("bishal", 3);
		mapobj.put("bishal", 6);
		System.out.print(mapobj.get("rahul"));
		
		System.out.print(mapobj);
		
		
		
		System.out.print("\n");
		System.out.println(collect2);
		
		System.out.print("\n");
		System.out.println(collect3);
	}

	/* 8) Longest substring*/
	String s1 = "abcabcbb"; // Expected: "abc", length 3
	String s2 = "bbbbb";
	// Expected: "b", length 1
	String s3 = "pwwkew"; // Expected: "wke", length 3
	String s4 = "";
// Expected: "", length 0
		System.out.println("Longest substring without repeating characters in s1: " + lengthOfLongestSubstring(s1)); // Output: 3
		System.out.println("Longest substring without repeating characters in s2: " + lengthOfLongestSubstring(s2)); // Output: 1
		System.out.println("Longest substring without repeating characters in s3: " + lengthOfLongestSubstring(s3)); // Output: 3
		System.out.println("Longest substring without repeating characters in s4: " + lengthOfLongestSubstring(s4)); // Output: 0


	public static int lengthOfLongestSubstring(String s) {

		HashSet<Character> set = new HashSet<>();
		int maxLength = 0;
		int start = 0;
		int end = 0;
		while (end < s.length()) {
			char currentChar = s.charAt(end);
			if (!set.contains(currentChar)) {
				set.add(currentChar);
				maxLength = Math.max(maxLength, end - start + 1);
				end++;
			} else {
				set.remove(s.charAt(start));
				start++;
			}
		}
		// Print the longest substring
		System.out.println("Longest substring: " + s.substring(start, end + 1));
		return maxLength;
	}

	//Left rotation of an array by k positions
	public static int[] rotateLeft(int[] arr, int k) {
		int n = arr.length;
		return Arrays.stream(arr)
				.skip(k % n)
				.boxed()
				.collect(Collectors.toList())
				.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}

	//Right rotation of an array by k positions
	public static int[] rotateRight(int[] arr, int k) {
		int n = arr.length;
		return Arrays.stream(arr)
				.skip(n - (k % n))
				.boxed()
				.collect(Collectors.toList())
				.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}
}
