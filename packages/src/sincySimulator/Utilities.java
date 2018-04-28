package sincySimulator;

/**
 * A series of public utilities to be used by the Sincy processor
 * @author martip23
 */
public class Utilities {
	
	static public enum registerNames {
		$zero, $at, $v0, $v1, $a0, $a1, $a2, $13, $t0, $t1, $t2,
		$t3, $t4, $t5, $t6, $t7, $s0, $s1, $s2, $s3, $s4, $s5, $s6,
		$s7, $t8, $t9, $k0, $k1, $gp, $sp, $fp, $ra	}
	
	/**
	 * A function to convert text instructions into binary representation
	 * 
	 * @param instruction in character string
	 * @return instruction in binary format
	 */
	static public String instructionToBinary(String instruction) {
		//@TODO: implementation
		return "-1";
	}
	
	/**
	 * A utility to convert decimal numbers to binary
	 * @param valueToConvert
	 * @return the binary value in int format
	 */
	static public int decimalToBinary(int valueToConvert) {
		return -1;
	}
	
	/**
	 * A utility to transform register codes into integers
	 * @param reg - register name
	 * @return - register index number
	 */
	static public int registerCodeToInt(String reg) {
		switch(reg) {
			case "$zero":
				return 0;
			case "$at":
				return 1;
			case "$v0":
				return 2;
			case "$v1":
				return 3;		
		}
		return -1;
	}
}
