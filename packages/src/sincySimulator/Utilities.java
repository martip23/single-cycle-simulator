package sincySimulator;

import java.util.Scanner;

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
		String op = "";
		String rs = "";
		String rt = "";
		String rd = "";
		String shamt = "";
		String funct = "";
		String imm = "";
		
		Scanner s = new Scanner(instruction);
		
		switch(s.next().toUpperCase()) {
			case("ADD"):
				op = "000000";
				rd = findRegisterCode(s.next());
				rs = findRegisterCode(s.next());
				rt = findRegisterCode(s.next());
				shamt = "00000";
				funct = "100000";
				break;
				
			case("ADDI"):
				op = "001000";
				rs = findRegisterCode(s.next());
				rt = findRegisterCode(s.next());
				imm = new Integer(0).toBinaryString(s.nextInt());
				while(imm.length()<16){
					imm = "0"+ imm;
				}
				break;
				
			case("SUB"):
				op = "000000";
				rd = findRegisterCode(s.next());
				rs = findRegisterCode(s.next());
				rt = findRegisterCode(s.next());
				shamt = "00000";
				funct = "100010";
				break;
				
			case("LW"):
				op = "010011";
				rs = findRegisterCode(s.next());
				imm = new Integer(0).toBinaryString(s.nextInt());
				while(imm.length()<16){
					imm = "0"+ imm;
				}
				rt = findRegisterCode(s.next());
				break;
				
			case("SW"):
				op = "101011";
				rs = findRegisterCode(s.next());
				imm = new Integer(0).toBinaryString(s.nextInt());
				while(imm.length()<16){
					imm = "0"+ imm;
				}
				rt = findRegisterCode(s.next());
				break;
				
			case("J"):
				op = "000010";
				imm = new Integer(0).toBinaryString(s.nextInt());
				while(imm.length()<26){
					imm = "0"+ imm;
				}
				break;
				
			case("BEQ"):
				op = "000100";
				rs = findRegisterCode(s.next());
				rt = findRegisterCode(s.next());
				imm = new Integer(0).toBinaryString(s.nextInt());
				while(imm.length()<16){
					imm = "0"+ imm;
				}
				break;
				
			case("AND"):
				funct = "100100";
				rd = findRegisterCode(s.next());
				rs = findRegisterCode(s.next());
				rt = findRegisterCode(s.next());
				break;
				
			case("OR"):
				funct = "100101";
				rd = findRegisterCode(s.next());
				rs = findRegisterCode(s.next());
				rt = findRegisterCode(s.next());
				break;
				
			case("MUL"):
				op = "011100";
				funct = "000010";
				rd = findRegisterCode(s.next());
				rs = findRegisterCode(s.next());
				rt = findRegisterCode(s.next());
				break;
				
			case("SLL"):
				op = "000000";
				rd = findRegisterCode(s.next());
				rs = findRegisterCode(s.next());
				rt = "00000";
				shamt = new Integer(0).toBinaryString(s.nextInt());
				while(shamt.length()<5){
					shamt = "0"+ shamt;
				}
				funct = "000000";
				break;
			
			case("SRL"):
				op = "000000";
				funct = "000010";
				rd = findRegisterCode(s.next());
				rs = findRegisterCode(s.next());
				rt = "00000";
				shamt = new Integer(0).toBinaryString(s.nextInt());
				while(shamt.length()<5){
					shamt = "0"+ shamt;
				}
				break;
		}
		s.close();
		return op+" "+rs+" "+rt+" "+rd+" "+shamt+" "+funct+" "+imm;
	}
	
	static public String findRegisterCode(String operation) {
		switch(operation) {
		case("$zero"):
			operation = "00000";
			break;
		case("$at"):
			operation = "00001";
			break;
		case("$v0"):
			operation = "00010";
			break;
		case("$v1"):
			operation = "00011";
			break;
		case("$a0"):
			operation = "00100";
			break;
		case("$a1"):
			operation = "00101";
			break;
		case("$a2"):
			operation = "00110";
			break;
		case("$a3"):
			operation = "00111";
			break;
		case("$t0"):
			operation = "01000";
			break;
		case("$t1"):
			operation = "01001";
			break;
		case("$t2"):
			operation = "01010";
			break;
		case("$t3"):
			operation = "01011";
			break;
		case("$t4"):
			operation = "01100";
			break;
		case("$t5"):
			operation = "01101";
			break;
		case("$t6"):
			operation = "01110";
			break;
		case("$t7"):
			operation = "01111";
			break;
		case("$s0"):
			operation = "10000";
			break;		
		case("$s1"):
			operation = "10001";
			break;
		case("$s2"):
			operation = "10010";
			break;
		case("$s3"):
			operation = "10011";
			break;
		case("$s4"):
			operation = "10100";
			break;
		case("$s5"):
			operation = "10101";
			break;
		case("$s6"):
			operation = "10110";
			break;
		case("$s7"):
			operation = "10111";
			break;
		case("$t8"):
			operation = "11000";
			break;
		case("$t9"):
			operation = "11001";
			break;
		case("$k0"):
			operation = "11010";
			break;
		case("$k1"):
			operation = "11011";
			break;
		case("$gp"):
			operation = "11100";
			break;
		case("$sp"):
			operation = "11101";
			break;
		case("$fp"):
			operation = "11110";
			break;
		case("$ra"):
			operation = "11111";
			break;
		}
		return operation;
	}
	
	/**
	 * A utility to convert decimal numbers to binary
	 * @param valueToConvert
	 * @return the binary value in int format
	 */
	static public String decimalToBinary(int valueToConvert) {
		StringBuilder binary = new StringBuilder("");
		for (int i = 1; i <= 32; i++) {
			binary.append(Integer.toString(valueToConvert%2));
			valueToConvert = valueToConvert >> 1;
			if (i%4 == 0) {
				binary.append(' ');
			}
		}
		
		return binary.reverse().toString();
	}
	
	/**
	 * A utility to transform register codes into integers
	 * @param reg - register name
	 * @return - register index number
	 */
	static public int registerCodeToInt(String reg) {
		reg = reg.replace(",","").toLowerCase();
		switch(reg) {
			case "$zero":
				return 0;
			case "$at":
				return 1;
			case "$v0":
				return 2;
			case "$v1":
				return 3;
			case "$a0":
				return 4;
			case "$a1":
				return 5;
			case "$a2":
				return 6;
			case "$a3":
				return 7;	
			case "$t0":
				return 8;
			case "$t1":
				return 9;
			case "$t2":
				return 10;
			case "$t3":
				return 11;	
			case "$t4":
				return 12;
			case "$t5":
				return 13;
			case "$t6":
				return 14;
			case "$t7":
				return 15;	
			case "$s0":
				return 16;
			case "$s1":
				return 17;
			case "$s2":
				return 18;
			case "$s3":
				return 19;	
			case "$s4":
				return 20;
			case "$s5":
				return 21;
			case "$s6":
				return 22;
			case "$s7":
				return 23;	
			case "$t8":
				return 24;
			case "$t9":
				return 25;
			case "$k0":
				return 26;
			case "$k1":
				return 27;
			case "$gp":
				return 28;
			case "$sp":
				return 29;
			case "$fp":
				return 30;
			case "$ra":
				return 31;	
		}
		return -1;
	}
}
