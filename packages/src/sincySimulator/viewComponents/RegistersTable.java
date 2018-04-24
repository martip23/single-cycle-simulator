package sincySimulator.viewComponents;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class RegistersTable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RegistersTable() {
		
		setTitle("Registers");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 486, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"00000", "$zero", "0", "0"},
				{"00001", "$at", "0", "0"},
				{"00010", "$v0", "0", "0"},
				{"00011", "$v1", "0", "0"},
				{"00100", "$a0", "0", "0"},
				{"00101", "$a1", "0", "0"},
				{"00110", "$a2", "0", "0"},
				{"00111", "$a3", "0", "0"},
				{"01000", "$t0", "0", "0"},
				{"01001", "$t1", "0", "0"},
				{"01010", "$t2", "0", "0"},
				{"01011", "$t3", "0", "0"},
				{"01100", "$t4", "0", "0"},
				{"01101", "$t5", "0", "0"},
				{"01110", "$t6", "0", "0"},
				{"01111", "$t7", "0", "0"},
				{"10000", "$s0", "0", "0"},
				{"10001", "$s1", "0", "0"},
				{"10010", "$s2", "0", "0"},
				{"10011", "$s3", "0", "0"},
				{"10100", "$s4", "0", "0"},
				{"10101", "$s5", "0", "0"},
				{"10110", "$s6", "0", "0"},
				{"10111", "$s7", "0", "0"},
				{"11000", "$t8", "0", "0"},
				{"11001", "$t9", "0", "0"},
				{"11010", "$k0", "0", "0"},
				{"11011", "$k1", "0", "0"},
				{"11100", "$gp", "0", "0"},
				{"11101", "$sp", "0", "0"},
				{"11110", "$fp", "0", "0"},
				{"11111", "$ra", "0", "0"},
			},
			new String[] {
				"Register(b)", "Register", "Data(b)", "Data(d)"
			}
		));
		contentPane.add(new JScrollPane(table));
		
	}

}
