package sincySimulator;

import sincySimulator.viewComponents.InstructionMemoryWindow;

/**
 * Holds instruction memory. Holds strings for commands and a binary representation.
 * Memory is of size 100.
 * @author martip23
 */
public class InstructionMemory {
	
	InstructionMemoryWindow imw;

	String[] instructions = new String[100];

	String[] binaryInstructions = new String[100];
	
	/**
	 * Initializes all memory locations to 0.
	 */
	public InstructionMemory(InstructionMemoryWindow imw) {
		this.imw = imw;
		for (int i = 0; i < 100; i++) {
			instructions[i] = "0";
			binaryInstructions[i] = "0000 0000 0000 0000 0000 0000 0000 0000";
		}
		this.imw.updateTable(instructions, binaryInstructions);
	}

	/**
	 * Stores an instruction string in memory
	 * @param i - Index to store at
	 * @param data - Instruction string to store.
	 */
	public void store(int k, String data) {
		instructions[k] = data;
		binaryInstructions[k] = Utilities.instructionToBinary(data);
		imw.updateTable(instructions, binaryInstructions);
	}
	
	/**
	 * Retrieves the instruction stored at this memory location
	 * @param i - Index to load from
	 * @return Binary representation of string.
	 */
	public String load(int i) {
		return instructions[i];
	}
}