/**
 * 
 */
package sincySimulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JEditorPane;

import sincySimulator.Utilities.registerNames;
import sincySimulator.viewComponents.ControlPanel;
import sincySimulator.viewComponents.DataMemory;
import sincySimulator.viewComponents.InstructionMemoryWindow;
import sincySimulator.viewComponents.InstructionWindow;
import sincySimulator.viewComponents.RegistersTable;

/**
 * @author martip23
 * This class is the controller (control unit) of the single cycle processor. 
 * It is the first thing to boot up. It starts by pulling a text field into 
 * instruction memory. It then initializes the program counter to 0. 
 * It then reads the first instruction and executes it using a 5 step
 * program. The 5 steps are fetch, decode, execute, memory access and write-back. The control unit
 * passes most of these tasks to other units and only takes care of decoding 
 * directly.
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
	
	int result;
	boolean willWrite = false;
	
	ALU alu; 				// Initializing the ALU
	
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
	 * @param filename the name of the file
	 * @return 
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
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		cp.setVisible(true);
	}
	
	/**
	 * Parses pieces of text in a scanner file for use in instructions
	 * @param sc Scanner file to scan
	 * @return A list of strings from the file
	 */
	ArrayList<String> parseText(Scanner sc) {
		ArrayList<String> inputData = new ArrayList<String>();
		while (sc.hasNextLine()) {
			inputData.add(sc.nextLine());
		}
		sc.close();
		return inputData;
	}
	
	/**
	 * Starts the processor.
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
	 * loads into currentIns.
	 */
	void fetch() {
		System.out.println("FETCH");
		currentIns = insMemory.load(PC);
		imw.highlightRow(PC);
		PC++;
	}
	
	/**
	 * Decodes an instruction and sends instruction and sends the required data
	 * to the correct location.
	 */
	void decode() {
		System.out.println("DECODE");
		Scanner sc = new Scanner(currentIns);
		System.out.println(currentIns);
		opCode = sc.next();
		System.out.println(opCode);
		des = sc.next();
		if (sc.hasNext()) {
			op1 = sc.next();
			op2 = sc.next();
			System.out.println(op2);
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
		opCode.toUpperCase();
		
		if (opCode.equals("ADD")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			int val2 = reg.load(Utilities.registerCodeToInt(op2));
			result = ALU.add(val1, val2);
			willWrite = true;
		} else if (opCode.equals("ADDI")) {
			int val1 = reg.load(Utilities.registerCodeToInt(op1));
			result = ALU.add(val1, Integer.parseInt(op2));
			willWrite = true;
		}
	}
	
	/**
	 * Stores the result into a register.
	 */
	void memory () {
		System.out.println("MEMORY");
		if (opCode == "LW")
			System.out.println("Load called");
		if (opCode == "SW")
			System.out.println("Store called");
	}
	
	void writeBack() {
		System.out.println("WRITEBACK");
		if (willWrite) {
			reg.write(Utilities.registerCodeToInt(des), result);
		}
	}
	
	/*
	 * Waits for the decided delay time.
	 */
	void delay() {
		try {
			Thread.sleep((long) (1000 * delay));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Operations on Button Presses
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
		System.out.println("Passing text");
		this.rawInput = editorPane;		
	}
}
