package sincySimulator;

/**
 * Starting point for the MIPS processor. Initializes Controller class.
 * @author martip23
 */
public class Main {

	/**
	 * Can read a file to pass instructions to Instruction Memory
	 * @param args - Filename
	 */
	public static void main(String[] args) throws Exception {
		String filename;
		if (args.length >= 1) {
			filename = args[0];
			
		} else {filename = null;}	
		Controller processor = (new Controller());
		Thread thread = new Thread(processor);
		
		System.out.println("Starting sincySimulator (prototype)... ");
		System.out.println("Pre-Read... ");
		processor.loadCode(filename);
		System.out.println("Running sincySimulator... ");
		thread.run();
		System.out.println("Finished running");
		

	}

}
