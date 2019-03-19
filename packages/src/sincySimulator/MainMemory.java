package sincySimulator;

import sincySimulator.viewComponents.DataMemory;

/** 
 * Creates an array of 100 strings which simulates 
 * the memory address 0-100, it takes in an address and it returns
 * the value stored at that particular address 
 * which is then stored into the memory
 *
 */
public class MainMemory {
	
	int[] mem= new int[100];
	DataMemory dm;
	
	/**
	 * Constructor that initializes all data memory to 0.
	 * @param dm - Reference to data memory window
	 */
	MainMemory(DataMemory dm) {
		this.dm = dm;
		for (int i = 0; i < 100; i++) {
			mem[i] = 0;
		}
		dm.updateTable(mem);
	}

	/**
	 * Stores an integer value in the table.
	 * @param data - Data to store
	 * @param address - represents address of i 
	 * @return Information at address will be value of data
	 */
	public void store(int data, int address)
	{	
		mem[address]= data;
		dm.updateTable(mem);
	}
	
	/**
	 * Loads the instruction from memory Location
	 * @param index - Memory location to load
	 * @return Returns the address at this location.
	 */
	public int load(int index)
	{
		int loadVal = mem[index];
		return (loadVal);
	}


}
