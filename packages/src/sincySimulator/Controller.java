/**
 * 
 */
package sincySimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JTextField;

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
public class Controller implements ActionListener {
	
	ThreadB b = new ThreadB();
	
	/**
	 * Constants for notify changed triggers.
	 */
	int INSTRUCTION_MEMORY = 1;
	boolean finishedInput = false;
	
	InstructionMemoryWindow im;
	InstructionWindow iw;
	ControlPanel cp = new ControlPanel(this);	// Reference to ControlPanel window
	RegistersTable rt = new RegistersTable();	//Reference to RegistersTable
	DataMemory dm = new DataMemory();			// Reference to Data Memory
	
	int delay = 0;		// This sets the delay of execution between code steps.
	int PC; 			// This creates a program counter for use by the control unit
	String currentIns; 	// Holds instruction being worked on NOW
	JEditorPane rawInput; 	// Holds raw input data from IW
	
	InstructionMemory insMemory; 		// Initializing the instruction memory unit
	MainMemory dataMem;		// Initializing the data memory unit
	Registers registers; 	// Initializing the register units
	ALU alu; 				// Initializing the ALU
	
	Controller() {
		im = new InstructionMemoryWindow();// Reference to Instruction Memory
		iw = new InstructionWindow(this);
		PC = 0;
	}
	
	public Controller(JEditorPane editorPane) {
		rawInput = editorPane;
		}
	
	/**
	 * Reads a file and loads all instructions into instruction memory.
	 * @param filename the name of the file
	 * @return 
	 */
	void loadCode(String filename) {
		ArrayList<String> inputData = new ArrayList<String>();
		
		if (filename == null) {
			iw.setVisible(true);
			waitUntilDone();
			iw.setVisible(false);
		} else {
			File file = new File(filename);
			
			try {
				Scanner sc = new Scanner(file);
				
				while (sc.hasNextLine()) {
					inputData.add(sc.next());
				}
				sc.close();
				for (int i = 0; i < inputData.size(); i++) {
					insMemory.store(i, inputData.get(i));
				}
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	cp.setVisible(true);
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
			im.setVisible(true);	
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
	

	@Override
	public void actionPerformed(ActionEvent e) {
		synchronized(this) {
			finishedInput = true;
			System.out.println("NOTIFIED");
			this.notifyAll();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
