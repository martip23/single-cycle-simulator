package sincySimulator;

/**
 * Starting point for the MIPS processor.
 * @author martip23
 */
public class Main {

	/**
	 * Can read a file to put instructions in Instruction Memory
	 * @param args - Filename
	 */
	public static void main(String[] args) {
		String filename;
		if (args.length >= 1) {
			filename = args[0];
			
		} else {filename = null;}		
		Controller processor = new Controller();	// Initialize our processor.
		
		System.out.println("Starting sincySimulator (beta)... ");
		System.out.println("Pre-Read... ");
		processor.loadCode(filename);
		System.out.println("Running sincySimulator... ");
		processor.run();
		System.out.println("Finished running");
		

	}

}
