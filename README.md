# Nur-Fatin-Microsoft-DEV276x-Learn-to-Program-in-Java. Here is the Notes from the course. 

Module 1 | Java Basics
1. Introduction
2. Writing your first Java program. What do I need to have?
	- What is Java? Features: object oriented, compiled means I can run on many OS, automatic memory management
	- Project Name = folder name,  Java file name, class name (must exactly match the Java file name). 
		- How to create name in Java?: Name has no space, start with letter, capitalize the first letter for each new word. 
	- Then, write code, compile/build, run
	- 3 parts of a Java Program.
		1. class: put method inside 
```
public class Filename {

}
```
		2. main method =  what the object does. All things that I want the computer to do, listed in the main method
```
public class Filename {
     public static void main(String[] args) {

     }
}
```

		3. statements: a command inside a method
```
public class Filename { 
     public static void main(String[] args) {
         System.out.println("Hello World");
     } 
}
```
		4. Extra Part: comments
			- Top/Multi-line comment: to describe overall function/what it was intended
```
/*
    This comment format is to describe the whole program
 */
```
			// - Single line comments: 
```
public class Filename { 
     public static void main(String[] args) { 
         System.out.println("Hello World");  // introduce myself
     }  
}
```

3. Basic Java Commands
	- Data type: Strings, println
		- System.out.println(produce string-based output to the console, by default if I don't add input, it will print a new line. It will  go to the next line to produce the next output)
		- print() will not go to the next line to produce the next output
	- Organize codes with Methods: a group of statements with chosen name. I can call the method name at any time in main method to run the codes inside. 
	  
		- To write large & useful programs need huge, millions lines of codes, I need the instructions to be organized & broken down into several segments (small & manageable about 50 lines at a time).  Because no one can understand and write all million lines of codes at once. 
		-  And, I need to avoid repeated codes/writing the same code more than once. To save time, so I can write more, easy to maintain
		- So, how do I break down a task into smaller chunks and avoid repeated codes in Java? = break program into methods. 
		- when to break down?: more than 25 lines, see redundancy, task can be broken down into important parts and when I did, I can understand it better, describe what the method does in a few words, if I can't break down further because a method must do only one specific thing. 
		- Method name = verbObject , use camel case
		- Main method, turn outline what the program is doing. 
		- How to create method
```
public class BakeCookies {
    public static void main(String[] args) { 
        bake();
    }

    public static void bake() {
        System.out.println("Bake");
    }
}
```

	- Control Flow = How computer read & run the codes => I need to read codes like a computer.  I give instructions to the computer then how the computer read and run my instructions? 

4. Data Types and Variables
	- Data Types:  what? 2 categories of data: basic(primitives save directly to the memory) like int, double, char, Boolean.  And complex(objects package together with other things) like String, images, sound. String =  a set of characters and each has their own index Why important? computer process many types of data. I need to know and define the type of data/info I'm using. So, the computer  know what operations can be performed on the input. How to use it? - Mathematical Operations: use integer to do math operation with correct order of operation, - String Concatenation: use String to join words, manipulate Strings using methods like charAt(0), length(), indexOf('e'). What happen when 2 data type interact? int + double = double, String + any data type = String. int / int = int, so if I divide 2 int and get decimals, Java will drop the numbers after the decimal points not round it. 

	- Variables = what? object/data that can change. Why important? I need it for the program because most of the real-world objects tell information that can change like watch. How to use it? Declare first: I give a data type name and a name to a piece of computer memory to store data that the program can manipulate later. DataType variableName = value;   local variable has a local scope, so if I declare it in method1, I cannot use it in method2. class variable has a class scope. What are common errors with variables? store wrong data type, call it with the wrong name, call before declare it and use it out of scope. 

	- class variable/class constants = what? not only variable, I can also store constant = data that less likely to change. Why important?   When I want all or more than 1 methods to use the same data for something like SPEED or to replace repeated numbers. It's not efficient to declare the same local variables. Better use and declare class variable once and use it everywhere. Then, when I need to change the data, I can change it in just one place, save time and avoid mistakes. It's ok to use in just 1 method, if I want to make the expression clear with the class constant name. How to use it?
```
public class myClass { 
public static final double PI = 3.14; 
public static final int MAX_SPEED = 80; 
public static final int DAYS_IN_WEEK = 7; 
public static void main(String[] args) {
```

	- Casting =  change data type. 

4. Make Interactive Programs that gets input from the user = what? : the user and computer can talk to each other.  Why important? Enable the user to use & control the program.  How to gets input from the user?  Many ways like keyboards, mice, touch screens, speech, etc. So, need different classes of objects to handle different input mechanisms.  To handle text input => Scanner object. Tell Java to find this class in util library and import it into my program. Create the Scanner object in main method and tell it to read text from System.in. Then, tell the object to pause and get the user input into the variable. So, I can process the user input and produce something. 
```
import java.util.Scanner;
public class LearnScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);       
        System.out.println("Welcome!"); 
        System.out.print("What is your name?");    
        String name = input.next();  
        System.out.print("What is your age?");
        int age = input.nextInt();
        System.out.print("What is your weight?");    
        double weight = input.nextDouble();        
        System.out.print("What is your dream?");
        String dream = input.nextLine();
        System.out.println("Hello " + name);
    }

}
```

Project  Trip Planner
Hands-On Lab
Assessment

Module 2 | Control Structures/ Control flow statements 
1. Introduction: Computer thinks in True or False. So, first step in software development is to break down human problems into True and False, 2 states. Then, translate that into codes. Right now my program can interact with the user but it does the same things when it gets different input. So, I need to add decision-making functionality to my program from simple to complex decision, so that it can do different things depending on the set conditions/user input. 
2. Logic
	- Booleans(true/false) = unit of logic, as the result of a test. Why important? logical value, can be used in control structure. How to use it? do the Boolean test with comparison operators for basic data types. To compare String I need to use String comparison methods. Eg: check if the user input meet the requirement. Do the test with the if statements
```
equals()
equalsIgnoreCase()
startsWith()
endsWith()
contains()
```

	- If else statements: What? See what might happen in the situation. For each thing to happen, what are the necessary (&&) and/or possible (| |) conditions? Set and test the conditions = If the result is true I decide to do this, if false I will do something different or I can test more conditions to see which one is true, if none of them is true I do something different.  Why important? Enable computer to decide what to do. So, My program become responsive, can do different things based on user input. 
```
if (test) {
    YOUR CODE HERE
} else if (test) {
    YOUR CODE HERE
} else {
    YOUR CODE HERE
}
```

		- Combining logic/nested if statements = When there are more than 1 necessary conditions for something to happen and all conditions must be true before I can run the codes. Use shortcuts / logical operators to combine Boolean expressions the AND operator (&&),  OR (| |), NOT (!)

3. Loop =  When I need to test a condition/info that always changing and I need to keep updating the program with new data, continue running until the test result is false. determining when and how the loop should "exit". repeat code within the program/ do the same thing  while the condition is true.  Test the condition in each iteration to check if the result is still true. while loop:  it's flexible how many times the codes repeat, depend on the type of test.  Like if I want to let the user determine when to end the loop/end the game.  But I need to make sure to include variable update, change the information in the loop. So, the computer know when to stop. for loop: when I need to repeat the code for a specific number  of time, so a variable is included in the statement to count how many times the code has been repeated eventually ends. Nested Loops = put loop inside another loop, result in more loop. 

```
variable initialization
while (test) {
    statements
    variable update
}

for (variable initialization; test; update) {
    statements
}
```

Project Odds or Evens
Hands-On Lab 
Assessment


Module 3 | Data Flow
1. Introduction. Enable the methods to take in input and produce output
2. How to pass information into a method using parameters =  take input/s in. Why important? I need to create program that's flexible, have methods that can accept different input and do different things, can work in many different situations/problems. When the method has parameters/can accept values, I/the user can pass in different input and get different output like calculator. 
3. How to get information out of a method using returns = take output out and pass a single info back to where it was called. How to return different data type? use method overloading = methods that have same names but do different things/ return different data type
```
public static void main(String[] args) {
    TYPE variable = name(parameters); // save the data from method call inside a variable
}

public static TYPE name(parameters) {
    // statements
    return data;
}
```

4. Data Processing Functions | How to do more complex math in programming? = use methods from built-in Math class. How to manipulate String data? = use built-in String class and its methods. To get more info about the String data =>  equals(), length(), charAt(PUT INDEX HERE), indexOf(PUT CHAR HERE). If the char occur multiple times I can find the last index of the char using lastIndexOf(), To change the String data => toUpperCase(), toLowerCase(), substring (START  INDEX, END INDEX), replace(old char, new char)

5. Recursion =  the ability of a method to call itself and repeat code to make the problem become smaller and smaller until the stopping point where cannot break the problem any further.  In each iteration, it will stack the new method instance until it reach the base case (the smallest piece of the problem), then it will unstack the method instances and return value to the original method call in main method. | How to build and read recursive algorithms (an algorithm that made up of small versions of itself.  =>  Like a Lego: The way to solve big problem is by breaking it up into smaller and smaller versions. Then, build them  back up together) =>  Plan "how can I break this complex problem down to simpler and simpler problems?", Find the pattern and turn that into code (put the base case in the if statements and recursive case in else statement.) can have several base cases and recursive calls. the recursive case need to call with different parameter value and move towards the base case. 
Project Crypto
Hands-On Lab 
Assessment


Module 4 | Final Project
Final Project - Maze Runner
