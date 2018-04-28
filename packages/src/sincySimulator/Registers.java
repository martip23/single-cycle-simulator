package sincySimulator;

import sincySimulator.viewComponents.RegistersTable;

/**
 * Holds register data. Designed to emulate register with load/store commands.
 * There are 32 registers.
 * @author martip23
 *
 */
public class Registers {
	RegistersTable rt;
	
	int[] registers = new int [32];

	/**
	 * Populates all registers to 0.
	 * @param rt - RegisterTable window to pass data to
	 */
	public Registers(RegistersTable rt) {
		this.rt = rt;
		for (int i = 0; i < 32; i++) {
			registers[i] = 0;
		}
		this.rt.updateTable(registers);
	}
	
	/**
	 * Writes to registers
	 * @param i = register binary address
	 * @param data = data to write
	 */
	public void write(int i, int data) {
		registers[i] = data;
		rt.updateTable(registers);
	}
	
	/**
	 * Reads the data at this register
	 * @param i = register to read
	 * @returns data at this register
	 */
	public int load(int i) {
		return registers[i];
	}

}
