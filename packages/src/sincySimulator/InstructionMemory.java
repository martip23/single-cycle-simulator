package sincySimulator;

/**
 * Holds instruction memory. Holds strings for commands and a binary representation
 * @author martip23
 */
public class InstructionMemory {

	String[] instructions = new String[100];
	String[] binaryInstructions = new String[100];

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
		return binaryInstructions[i];
	}
}