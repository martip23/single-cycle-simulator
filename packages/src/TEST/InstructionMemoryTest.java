package TEST;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sincySimulator.InstructionMemory;
import sincySimulator.viewComponents.InstructionMemoryWindow;

class InstructionMemoryTest {
	
	@Test
	void testStoreLoad() {
		InstructionMemory mem = new InstructionMemory(new InstructionMemoryWindow());
		mem.store(0, "FIRST INSTRUCTION");
		mem.store(1, "SECOND INSTRUCTION");
		mem.store(99, "LAST INSTRUCTION");
		
		assertEquals("FIRST INSTRUCTION", mem.load(0));
		assertEquals("SECOND INSTRUCTION", mem.load(1));
		assertEquals("LAST INSTRUCTION", mem.load(99));
	}

}
