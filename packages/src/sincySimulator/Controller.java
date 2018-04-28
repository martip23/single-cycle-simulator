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
 * @author martip23
 * This class is the controller (control unit) of the single cycle processor. 
 * It is the first thing to boot up. It starts by pulling a text field into 
 * instruction memory. It then initializes the program counter to 0. 
 * It then reads the first instruction and executes it using a 5 step
 * program. The 5 steps are fetch, decode, execute, memory access and write-back. The control unit
 * passes most of these tasks to other units and only takes care of decoding 
 * directly.
 */
public class Controller {
	
	
	/**
	 * Constants for notify changed triggers.
	 */
	int INSTRUCTION_MEMORY = 1;
	boolean finishedInput = false;
	
	InstructionMemoryWindow imw;
	InstructionMemory insMemory; // Initializing the instruction memory unit
	
	DataMemory dm;
	MainMemory mainMem; // Initializing the data memory unit
	
	Registers reg;
	RegistersTable rt;
	
	InstructionWindow iw;
	ControlPanel cp = new ControlPanel(this);	// Reference to ControlPanel window
	
	int delay = 0;		// This sets the delay of execution between code steps.
	int PC; 			// This creates a program counter for use by the control unit
	String currentIns; 	// Holds instruction being worked on NOW
	JEditorPane rawInput; 	// Holds raw input data from IW
	
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
		ArrayList<String> inputData;
		
		if (filename == null) {
			iw.setVisible(true);
//			waitUntilDone();
//			iw.setVisible(false);
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
	void runProc() {
		while(true) {
			fetch();
			decode();
			execute();
			store();
		}
	}
	
	/**
	 * Gets the next instruction from instruction memory and 
	 * loads into currentIns.
	 */
	void fetch() {
		
	}
	
	/**
	 * Decodes an instruction and sends instruction and sends the required data
	 * to the correct location.
	 */
	void decode() {
		
	}
	
	/**
	 * Passes the required calculation to the ALU.
	 */
	void execute() {
		
	}
	
	/**
	 * Stores the result into a register.
	 */
	void store () {
		
	}
	
	/**
	 * Notify the GUI that the state of one of the models has changed.
	 * @param msg String declaring the type of change.
	 */
	void notifyChanged(String msg) {
		
	}
	
	/**
	 * Operations on Button Presses
	 * @param option - Button that was clicked
	 */
	public void operation(String option) {
		if (option.equals("Start Execution")) {
			System.out.println("Starting Exectuion");			
		} else if (option.equals("Resume")) {
			System.out.println("Resuming Exectuion");	
		} else if (option.equals("Pause")) {
			System.out.println("Pausing Exectuion");	
		} else if (option.equals("Step")) {
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
	}
	
	public synchronized void waitUntilDone() {
		synchronized(this) {
			while (!finishedInput) {
				try {
					this.wait();
				} catch (InterruptedException ignore) {
					System.out.println("EXCEPTION!");
				}
			}
		}
	}
	

	public void pushInputToMemory() {
		System.out.println("Loading from IW");
		Scanner sc = new Scanner(rawInput.getText());
		ArrayList<String> inputData = parseText(sc);
		for (int i = 0; i < inputData.size(); i++) {
			insMemory.store(i, inputData.get(i));
		}
	}

	public void passText(JEditorPane editorPane) {
		System.out.println("Passing text");
		this.rawInput = editorPane;		
	}
}
