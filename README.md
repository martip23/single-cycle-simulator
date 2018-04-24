# Sincy - Single Cycle Simulator
A single cycle simulator w/ GUI built in java to demonstrate how a single cycle processor would work.

# Team Members & Roles #

| Name   	  | Title                             |
|-------------|-----------------------------------|
| **Patrick** | GUI Developer and Chief Architect |
| **Troy**    | Lead Developer                    |
| **Mary**    | Team Manager and Developer        |


## **Problem:** ##
 
As a programmer it is important to know how a cycle simulator works, but it is hard to to understand the single cycle processor.

The process behind the single simulator is important to understand in computer architecture.
In order to understand something as a programmer you want to understand the process but also relate to the computer architecture.
Therefore the students decided to create a single cycle simulator with a GUI in java which would 
demonstrate the single cycle program. Understanding a single cycle simulator will give a better understanding 
of the more complicated simulators.

## **Expectation** ##
We expect to deliver a single cycle processor simulator that can accept a few assembly instructions and show where the information would begin and end in a single cycle processor.

## **Methodology** ##

1. Design a model for the implementation of a single cycle processor in Java.
2. Design an intuitive and easy to read front-end (GUI) for the program.
1. Decide on classes and functions that programs will use, write skeleton classes and functions with detailed documentation.
2. Begin dividing up labor between classes and functions and begin implementation of classes and functions.
	1. Special care is being taken to ensure accurate javaDoc style documentation to generate program documentation with ease.
2. Create a GUI to be used by the program and to be shown to the user.
3. Begin implementation of the controller. It initialized all of the components and executes instructions using the 5 step MIPS cycle which are
	1. IF (Instruction Fetch)
	2. ID (Instruction Decode)
	3. EX (Execute)
	4. MEM(Memory Read/Write)
	5. REG(Register Write) 
6. Test and debug components using a test suite like jUnit.
7. Begin implementation of the GUI.
3. Begin linking the GUI with the program by using MVC guidelines. In this case, we're using a Model Model-Controller View architecture where the controller class acts as both the program controller and model for the processor. Individual components are all Model but have access to the View.
4. Perform integration tests.

## Deliverables ##
We will prepare a read me, access to the program code, an accompanying PowerPoint presentation and documentation to support this program. A live demo will be presented in class at which time questions may be answered.

## Instruction Set Architecture ##
### Instructions Supported ###

| Instruction Name 	| Opcode 	| Function  	| Type 	|
|------------------	|--------	|-----------	|------	|
| ADD              	| 000000 	| 100000    	| R    	|
| ADDI             	| 001000 	| N/A       	| I    	|
| SUB              	| 000000 	| 100010    	| R    	|
| LW               	| 010011 	| N/A       	| I    	|
| SW               	| 101011 	| N/A       	| I    	|
| J                	| 000010 	| N/A       	| I    	|
| BEQ              	| 000100 	| N/A       	| I    	|
| AND              	| 000000 	| 100100    	| R    	|
| OR               	| 000000 	| 100101    	| R    	|
| MUL              	| 011100 	| 000010    	| R    	|
| SLL              	| 000000 	| 000000    	| R    	|
| SRL              	| 000000 	| 000010    	| R    	|
| NOP              	| 000000 	| 000000    	| R    	|



