DNASequencer
The DNASequencer is a Java program that processes a list of DNA strand strings and performs specific operations to find and manipulate the first two valid DNA strands. A valid DNA strand contains only the characters 'a', 'c', 'g', and 't' and is longer than 3 characters.

Features
Valid DNA Strand Identification: The program identifies the first two DNA strands from the input arguments that meet the criteria of containing only 'a', 'c', 'g', and 't' characters and being longer than 3 characters.
String Manipulation: If both valid strands are found, the program manipulates the first strand based on the contents of the second strand.
Output: The final version of the first strand is outputted, showing the result of the manipulation process.

Usage
To compile and run the program, use the following commands:
javac DNASequencer.java
java DNASequencer <strand1> <strand2> ...

Example
Given the input arguments aaaggts tcgtac fdhgvf rhef as hgjf, the program processes the strands to find and manipulate the first valid DNA strands and produces the following output:DNA molecule: tcgtac

Usage

Compile the DNASequencer.java file:
javac DNASequencer.java

Run the compiled Java program:
java DNASequencer your input
