
package com.example.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java_practice {

	public static void main(String args[])
	{
	//1.Arrays
		
	//Removing duplicates from array
	int arr[]= {1,1,2,2,3,4,5,5,6,6};
	
	List<Integer> collect = Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());
	
	Object[] array = collect.stream().toArray();
	//Arrays.stream(array).forEach(result -> System.out.println(result));
	
	
	//Printing non-duplicate element only
	
	List<Integer> collect2 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).
		entrySet().stream().filter(mapres -> mapres.getValue()==1).map(mapval -> mapval.getKey()).collect(Collectors.toList());
	
	 Integer[] array2 = collect2.toArray(new Integer[0]);	
	 
	// System.out.println(Arrays.toString(array2));
	//collect2.stream().forEach(result -> System.out.println(result));
	
	//Printing duplicate element only
	 
	  Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	 .entrySet().stream().filter(mapres -> mapres.getValue()>1).map(mapval -> mapval.getKey()).collect(Collectors.toList())
	 .forEach(result -> System.out.println(result));
	 
	 	
	 //Print even number/ odd numbers and print counts
	  int arr1[]= {1,2,3,4,5,6,7,8,9};
	  
	  Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	  	.entrySet().stream().filter(mapres -> mapres.getKey() % 2==0).map(mapval -> mapval.getKey())
	  	.collect(Collectors.toList()).forEach(res -> System.out.println(res));
	 
	  
	  long count = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	  	.entrySet().stream().filter(mapres -> mapres.getKey() % 2==0).map(mapval -> mapval.getKey()).count();	 
	 
	 System.out.print(count);
	 
	 
	 //Second largest & second smallest element
	 int arr2[]= {1,2,3,4,22,18,7,8,1,2,3,4,5,6,7,8,9};
	 
	 //reverse array
	 int[] reversedArray = IntStream.range(0, arr2.length)
             .map(i -> arr2[arr2.length - 1 - i]) // Fetch elements in reverse order
             .toArray();
	  
	 System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
	 
	 List<Integer> collect3 = Arrays.stream(arr2).boxed().distinct().collect(Collectors.toList());
	 //Largest
	 Integer integer = collect3.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	 Integer integer2 = collect3.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().get();
	 
	 System.out.println("large " + integer + ", small " +integer2);
	 
	 //Rotate the given array
     
	 //Left Rotate
	 List<Integer> leftcoll = IntStream.range(1, collect3.size()).mapToObj(collect3::get).collect(Collectors.toList());
     leftcoll.add(collect3.get(0));
     
     List<Integer> rightcoll= new ArrayList<Integer>();
     rightcoll.add(collect3.size()-1);
     rightcoll.addAll(IntStream.range(0, collect3.size()-1).mapToObj(collect3::get).collect(Collectors.toList()));
     
     System.out.println("left rotate" +leftcoll + ", right rotate" + rightcoll);
     
     //Swap second-last with second
     int secondIndex = 1;
     int secondLastIndex = arr2.length - 2;

     // Swapping second and second-last elements using Streams
     int[] swappedArray = IntStream.range(0, arr2.length)
             .map(i -> i == secondIndex ? arr2[secondLastIndex] : // Replace second element with second-last
                       i == secondLastIndex ? arr2[secondIndex] : // Replace second-last with second
                       arr2[i]) // Keep others unchanged
             .toArray();

     // Printing the swapped array
     System.out.println("Swapped Array: " + Arrays.toString(swappedArray));
     
     
     //2.Strings
     
     //Removing duplicates from strings
     String test="adnmbsdmnsajkqwaaadd";
     
     Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
     	.entrySet().stream().filter(mapres -> mapres.getValue() >1).map(mapval -> mapval.getKey()).collect(Collectors.toList()).forEach(res -> System.out.print(res));
     
     //Occurance of each character
     Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().forEach(res-> System.out.println(res));
     
     System.out.println(lengthOfLongestSubstring(test));
      
     System.out.println(areAnagrams(test, test));
     
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
    	
    	        List<Employee1> employees = Arrays.asList(
    	                new Employee1(1, "Alice", "IT", 70000, 2012),
    	                new Employee1(2, "Bob", "HR", 50000, 2018),
    	                new Employee1(3, "Charlie", "IT", 80000, 2016),
    	                new Employee1(4, "David", "Finance", 60000, 2014),
    	                new Employee1(5, "Eve", "HR", 55000, 2020),
    	                new Employee1(6, "Frank", "Finance", 75000, 2011)
    	        );

    	        // 1. Group employees by department
    	        Map<String, List<Employee1>> employeesByDepartment = employees.stream()
    	                .collect(Collectors.groupingBy(Employee1::getDepartment));

    	        System.out.println("Employees grouped by department:");
    	        employeesByDepartment.forEach((dept, empList) -> {
    	            System.out.println(dept + ": " + empList);
    	        });

    	        // 2. Find the highest-paid employee in each department
    	        Map<String, Optional<Employee1>> highestPaidByDepartment = employees.stream()
    	                .collect(Collectors.groupingBy(
    	                        Employee1::getDepartment,
    	                        Collectors.maxBy(Comparator.comparingDouble(Employee1::getSalary))
    	                ));

    	        System.out.println("\nHighest-paid employee in each department:");
    	        highestPaidByDepartment.forEach((dept, emp) -> 
    	            System.out.println(dept + ": " + emp.get()));

    	        // 3. Get a list of employees who joined after 2015
    	        List<Employee1> employeesAfter2015 = employees.stream()
    	                .filter(e -> e.getYearOfJoining() > 2015)
    	                .collect(Collectors.toList());

    	        System.out.println("\nEmployees who joined after 2015:");
    	        employeesAfter2015.forEach(System.out::println);
    	        
    	        // 4. Female employee count
    	        Map<String, Long> femaleEmployeeCountByDepartment = employees.stream()
    	                .filter(e -> "Female".equalsIgnoreCase(e.getGender())) // Filter only female employees
    	                .collect(Collectors.groupingBy(
    	                        Employee1::getDepartment, 
    	                        Collectors.counting()
    	                ));

    	        System.out.println("Total count of female employees in each department:");
    	        femaleEmployeeCountByDepartment.forEach((dept, count) -> 
    	                System.out.println(dept + ": " + count));
     
	}

	public static int lengthOfLongestSubstring(String s) {
		HashSet<Character> set = new HashSet<>();
		 int longestStart=0;
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

		String longestSubstring = s.substring(longestStart, longestStart + maxLength);
	        System.out.println("Longest Substring: " + longestSubstring);
		return maxLength;
		
		
	}
	
	static boolean areAnagrams(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] charCount = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			charCount[str1.charAt(i)]++;
			charCount[str2.charAt(i)]--;
		}
		for (int count : charCount) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
}

	