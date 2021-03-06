/**
 * 
 */
package sincySimulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JEditorPane;

import sincySimulator.viewComponents.ControlPanel;
import sincySimulator.viewComponents.DataMemory;
import sincySimulator.viewComponents.InstructionMemoryWindow;
import sincySimulator.viewComponents.InstructionWindow;
import sincySimulator.viewComponents.RegistersTable;

/**
 * This class is the controller (control unit) of the single cycle processor. 
 * It is the first thing to boot up. It starts by pulling a text field into 
 * instruction memory. The instruction memory may be passed as a filename 
 * by passing an argument or typed directly when no arguments are provided.
 * It then initializes the program counter to 0. 
 * It then reads the first instruction and executes it using a 5 step
 * program. The 5 steps are fetch, decode, execute, memory access and write-back. The control unit
 * passes most of these tasks to other units and only takes care of decoding 
 * directly.
 * @author martip23
 */
public class Controller implements Runnable{
	
	Thread time;

	/**
	 * Constants for notify changed triggers.
	 */
	boolean runFlag = false;
	boolean stepFlag = false;
	String filename;
	
	JEditorPane rawInput; 	// Holds raw input data from IW
	
	InstructionMemoryWindow imw;
	InstructionMemory insMemory; // Initializing the instruction memory unit
	int instructionTotal = 0;
	
	DataMemory dm;
	MainMemory mainMem; // Initializing the data memory unit
	
	Registers reg;
	RegistersTable rt;
	
	InstructionWindow iw;
	ControlPanel cp = new ControlPanel(this);	// Reference to ControlPanel window
	
	float delay = 1f;		// This sets the delay of execution between code steps.
	int PC; 			// This creates a program counter for use by the control unit
	
	String currentIns; 	// Holds instruction being worked on NOW
	
	String opCode;
	String des;
	String op1;
	String op2;
	int shamft;
	int funct;
	
	int memVal;
	int result;
	boolean willWrite = false;
	
	ALU alu; 				// Initializing the ALU
	
	/**
	 * The controller constructor initializes the view.
	 */
	Controller() {	
		imw = new InstructionMemoryWindow();
		insMemory = new InstructionMemory(imw);
		
		dm = new DataMemory();
		mainMem = new MainMemory(dm);
		
		rt = new RegistersTable();
		reg = new Registers(rt);
		
		
		iw = new InstructionWindow(this);
		PC = 0;
	}
	
	public Controller(JEditorPane editorPane) {
		this.rawInput = editorPane;
	}
	
	/**
	 * Reads a file and loads all instructions into instruction memory.
	 * If there is no file name passed as an argument it will then open
	 * an instruction window so ASM can be entered manually.
	 * @param filename the name of the file
	 * @return Passes the instructions to the instruction menu. If there
	 * is no filename (not ran from command line) then this function will
	 * instead open an instruction window.
	 */
	void loadCode(String filename) {
		@SuppressWarnings("unused")
		
		ArrayList<String> inputData;
		this.filename = filename;		
		if (filename == null) {
			iw.setVisible(true);
		} else {
			File file = new File(filename);
			
			try {
				Scanner sc = new Scanner(file);
				inputData = parseText(sc);
				for (int i = 0; i < inputData.size(); i++) {
					insMemory.store(i, inputData.get(i));
				}
			}
			catch (FileNotFoundException e) {
				iw.setVisible(true);
			}
		}
		cp.setVisible(true);
	}
	
	/**
	 * Parses pieces of text in a scanner file for use in instructions. Gets
	 * each line and adds it to a list named inputData.
	 * @param sc Scanner file to scan
	 * @return A list of strings from the file
	 */
	ArrayList<String> parseText(Scanner sc) {
		ArrayList<String> inputData = new ArrayList<String>();
		while (sc.hasNextLine()) {
			inputData.add(sc.nextLine());
		}
		sc.close();
		instructionTotal = inputData.size();
		return inputData;
	}
	
	/**
	 * Starts the processor. It calls fetch, decode, execute
	 * memory and write-back in that order.
	 */
	public void run() {
		while(true) {
			while(!runFlag && !stepFlag) {
				synchronized(this) {
					try {
						System.out.println("Waiting...");
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		fetch();
		decode();
		execute();
		memory();
		writeBack();
		if (stepFlag) {
			stepFlag = false;
		} else { delay();}
	}
}
	
	/**
	 * Gets the next instruction from instruction memory and 
	 * loads into currentIns. Which will be displayed on the
	 * instruction memory. It also highlights the row 
	 * corresponding to the current instruction running.
	 */
	void fetch() {
		System.out.println("FETCH");
		currentIns = insMemory.load(PC);
		imw.highlightRow(PC);
	}
	
	/**
	 * Decodes an instruction and sends instruction and sends the required data
	 * to the correct location.
	 */
	void decode() {
		System.out.print("DECODE: ");
		Scanner sc = new Scanner(currentIns);
		System.out.println(currentIns);
		opCode = sc.next();
		opCode = opCode.toUpperCase();
		des = sc.next();
		des.replace(",", "");
		if (sc.hasNext()) {
			op1 = sc.next();
			op1.replace(",", "");
			op2 = sc.next();
			op2.replace(",", "");
		}
		if (sc.hasNext()) {
			shamft = Integer.parseInt(sc.next());
			funct = Integer.parseInt(sc.next());
		}
		sc.close();
	}
	
	/**
	 * Passes the required calculation to the ALU.
	 */
	void execute() {
		System.out.println("EXECUTE");
		
		if (opCode.equals("ADD")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			int val2 = reg.load(Utilities.registerCodeToInt(op2));
			result = ALU.add(val1, val2);
			willWrite = true;
		} else if (opCode.equals("ADDI")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			result = ALU.add(val1, Integer.parseInt(op2));
			willWrite = true;
		} else if (opCode.equals("SUB")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			int val2 = reg.load(Utilities.registerCodeToInt(op2));
			result = ALU.sub(val1, val2);
			willWrite = true;
		} else if (opCode.equals("MUL")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			int val2 = reg.load(Utilities.registerCodeToInt(op2));
			result = ALU.mul(val1, val2);
			willWrite = true;
		} else if (opCode.equals("AND")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			int val2 = reg.load(Utilities.registerCodeToInt(op2));
			result = ALU.and(val1, val2);
			willWrite = true;
		} else if (opCode.equals("OR")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			int val2 = reg.load(Utilities.registerCodeToInt(op2));
			result = ALU.or(val1, val2);
			willWrite = true;
		} else if (opCode.equals("SLL")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			int val2 = Integer.parseInt(op2);
			result = ALU.sll(val1, val2);
			willWrite = true;
		} else if (opCode.equals("SRL")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			int val2 = Integer.parseInt(op2);
			result = ALU.srl(val1, val2);
			willWrite = true;
		} else if (opCode.equals("LW")) {
			int val1 = Integer.parseInt(op1);
			int val2 = reg.load(Utilities.registerCodeToInt(op2));
			result = ALU.add(val1, val2);
			willWrite = true;
		} else if (opCode.equals("SW")) {
			int val1 = Integer.parseInt(op1);
			int val2 = reg.load(Utilities.registerCodeToInt(op2));
			result = ALU.add(val1, val2);
			willWrite = false;
		} else if (opCode.equals("BEQ")) {
			int val1 = reg.load(Utilities.registerCodeToInt(des));
			int val2 = reg.load(Utilities.registerCodeToInt(op1));
			if(ALU.beq(val1, val2)) {
				PC += Integer.parseInt(op2)-1;
			}
			willWrite = false;
		} else if (opCode.equals("J")) {
			PC = Integer.parseInt(des)-1;
			System.out.println(PC);
			willWrite = false;
		}
	}
	
	/**
	 * Stores the result into a register.
	 */
	void memory () {
		System.out.println("MEMORY");
		if (opCode.equalsIgnoreCase("LW")) {
			System.out.println("Load called");
			result = mainMem.load(result);
		}
		if (opCode.equalsIgnoreCase("SW")) {
			System.out.println("Store called");
			mainMem.store(reg.registers[Utilities.registerCodeToInt(des)], result);
		}
	}
	
	/**
	 * Write the information to memory.
	 */
	void writeBack() {
		System.out.println("WRITEBACK");
		if (willWrite) {
			reg.write(Utilities.registerCodeToInt(des), result);
			if (opCode.equals("LW")) {
				reg.write(Utilities.registerCodeToInt(des), memVal);
			}
		}
		PC++;
		if (PC == instructionTotal) {
			runFlag = false;
		}
	}
	
	/*
	 * Waits for the decided delay time.
	 */
	void delay() {
		delay = getDelay();
		try {
			Thread.sleep((long) (1000 * delay));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Operations on Button Presses. Calls correction method for button.
	 * @param option - Button that was clicked
	 */
	public synchronized void operation(String option) {
		if (option.equals("Start Execution")) {
			System.out.println("Starting Exectuion");
			loadCode(filename);
			runFlag = true;
		} else if (option.equals("Resume")) {
			runFlag = true;
			System.out.println("Resuming Exectuion");	
		} else if (option.equals("Pause")) {
			runFlag = false;
			System.out.println("Pausing Exectuion");	
		} else if (option.equals("Step")) {
			stepFlag = true;
			System.out.println("Stepping through Exectuion");	
		} else if (option.equals("View Registers")) {
			rt.setVisible(true);
		} else if (option.equals("View Data Memory")) {
			dm.setVisible(true);	
		} else if (option.equals("View Instruction Memory")) {
			imw.setVisible(true);	
		} else if (option.equals("Finished")) {
			pushInputToMemory();
		}
		synchronized(this) {
			this.notifyAll();
		}
	}

	/**
	 * Used to push the initial code to instruction memory.
	 */
	public void pushInputToMemory() {
		System.out.println("Loading from IW");
		Scanner sc = new Scanner(rawInput.getText());
		ArrayList<String> inputData = parseText(sc);
		for (int i = 0; i < inputData.size(); i++) {
			insMemory.store(i, inputData.get(i));
		}
	}

	/**
	 * Used to facilitate the transfer of the editor pane text box to the
	 * controller
	 * @param editorPane - The text box
 	 */
	public void passText(JEditorPane editorPane) {
		this.rawInput = editorPane;		
	}
	
	/**
	 * Gets the delay from control panel view
	 * @return the delay as a float.
	 */
	public float getDelay() {		
		return cp.getDelay();
	}
}
