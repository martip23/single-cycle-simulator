package sincySimulator;

/**
 * Holds instruction memory. Holds strings for commands and a binary representation.
 * Memory is of size 100.
 * @author martip23
 */
public class InstructionMemory {

	String[] instructions = new String[100];

	String[] binaryInstructions = new String[100];
	
	/**
	 * Initializes all memory locations to 0.
	 */
	public InstructionMemory() {
		for (int i = 0; i < 100; i++) {
			instructions[i] = "0";
			binaryInstructions[i] = "0000 0000 0000 0000 0000 0000 0000 0000";
		}
	}

	/**
	 * Stores an instruction string in memory
	 * @param i - Index to store at
	 * @param string - Instruction string to store.
	 */
	public void store(int i, String string) {
		instructions[i] = string;
		binaryInstructions[i] = Utilities.instructionToBinary(string);
	}
	
	/**
	 * Retrieves the instruction stored at this memory location
	 * @param i - Index to load from
	 * @return Binary representation of string.
	 */
	public String load(int i) {
		return instructions[i];
	}
	
	/**
	 * @return the instructions
	 */
	public String[] getInstructions() {
		return instructions;
	}

	/**
	 * @param instructions the instructions to set
	 */
	public void setInstructions(String[] instructions) {
		this.instructions = instructions;
	}

	/**
	 * @return the binaryInstructions
	 */
	public String[] getBinaryInstructions() {
		return binaryInstructions;
	}

	/**
	 * @param binaryInstructions the binaryInstructions to set
	 */
	public void setBinaryInstructions(String[] binaryInstructions) {
		this.binaryInstructions = binaryInstructions;
	}
}