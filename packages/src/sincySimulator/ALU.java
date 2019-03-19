package sincySimulator;

/**
 * Simulates an ALU. Supports 13 instructions.
 * @author martip23
 *
 */
public class ALU {

	/**
	 * Adds two values op1 and op2
	 * @param op1 
	 * @param op2
	 * @return Sum of op1 & op2
	 */
	public static int add(int op1, int op2) {
		return op1 + op2;		
	}
	
	/**
	 * Subtracts op2 from op1
	 * @param op1
	 * @param op2
	 * @return Difference of op1 & op2
	 */
	public static int sub(int op1, int op2) {
		return op1 - op2;		
	}
	
	/**
	 * Multiplies op1 and op2
	 * @param op1
	 * @param op2
	 * @return Product of op1 & op2
	 */
	public static int mul(int op1, int op2) {
		return op1 * op2;		
	}
	
	/**
	 * Returns logical and result of op1 & op2
	 * @param op1
	 * @param op2
	 * @return result of op1 & op2
	 */
	public static int and(int op1, int op2) {
		return op1 & op2;
	}
	
	/**
	 * Returns logical or of op1 & op2
	 * @param op1
	 * @param op2
	 * @return result of op1 | op2
	 */
	public static int or(int op1, int op2) {
		return op1 | op2;
	}
	
	/**
	 * Shift op1 op2 spaces left
	 * @param op1
	 * @param op2
	 * @return Returns the value of op1 after it's shifted left by the value
	 * of op2
	 */
	public static int sll(int op1, int op2) {
		return op1 * (op2 * 2);
	}
	
	/**
	 * Shift op1 op2 spaces right
	 * @param op1
	 * @param op2
	 * @return Returns the value of op1 after it's shifted right by the value
	 * of op2
	 */
	public static int srl(int op1, int op2) {
		return op1 / (op2 *2);
	}
	
	/**
	 * Compares op1 & op2
	 * @param op1
	 * @param op2
	 * @return Returns true of op1 is equal to op2. Otherwise returns false.
	 */
	public static boolean beq(int op1, int op2) {
		if(op1 == op2) {
			return true;
		} else {
			return false;
		}
	}
}
