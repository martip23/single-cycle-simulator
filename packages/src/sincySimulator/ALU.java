package sincySimulator;

/**
 * Simulates an ALU. Supports 13 instructions.
 * @author martip23
 *
 */
public class ALU {

	public static int add(int op1, int op2) {
		return op1 + op2;		
	}
	public static int sub(int op1, int op2) {
		return op1 - op2;		
	}
	public static int mul(int op1, int op2) {
		return op1 * op2;		
	}
	public static int and(int op1, int op2) {
		return op1 & op2;
	}
	public static int or(int op1, int op2) {
		return op1 | op2;
	}
	public static int sll(int op1, int op2) {
		return op1 * (op2 * 2);
	}
	public static int srl(int op1, int op2) {
		return op1 / (op2 *2);
	}
	public static boolean beq(int op1, int op2) {
		if(op1 == op2) {
			return true;
		} else {
			return false;
		}
	}
}
