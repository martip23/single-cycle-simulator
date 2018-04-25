package sincySimulator;

import java.util.ArrayList;

/** enter above function or class 
 * 
 * Creates an array of 100 strings which simulates 
 * the memory address 0-100, it takes in an address and it returns
 * the value stored at that particular address 
 * which is then stored into the memory
 *
 */
public class MainMemory {

	int[] mem= new int[100];

	/** enter above function or class 
	 * Stores an instruction string into memory trough an Array
	 *  @param i - index of the Array
	 *  @param address - represents address of i 
	 *  	 
	 */
	public void store(int data, int address)
	{
		
		mem[address]= data;
		
	}
	
	/** enter above function or class 
	 * Loads the instruction from memory Location
	 * @param string - stores value located at index i 
	 */
	public int load(int data)
	{
		
		return mem[data];
		

	}


	}
