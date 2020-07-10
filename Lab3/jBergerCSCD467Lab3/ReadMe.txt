Name: Jacob Berger
Description: Unzip jBergerCSCD467Lab3.zip.
To Compile: cd into folder jBergerCSCD467Lab3,
	javac *.java
To Run: java Alternation

Q1: Why the provided solution does NOT work? Which statement(s) cause the program to hang up?
After t1 runs the first loop, the boolean is set to false meaning it is now t2's turn to run. However, the for loop will continue to run get stuck at "while(!isT1turn);" since isT1turn is false, evaluating to true;

Q2: How did you fix that problem?
I changed the for loop to "while (t1count <= 50)" in t1 and t2 respectively. I also changed "while(!isT1turn)" to "if (isT1turn)" in t1 and "if (!isT1turn)" in t2.

Q3: How does your changes fix the problem?
There is now no while loop within the synchronized blocks where the boolean can change and then get stuck.