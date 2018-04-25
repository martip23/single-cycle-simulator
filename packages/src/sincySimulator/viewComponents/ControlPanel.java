package sincySimulator.viewComponents;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sincySimulator.Controller;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ControlPanel extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public ControlPanel(Controller cont) {
		controller = cont;
		
		setTitle("Sincy Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartExecution = new JButton("Start Execution");
		btnStartExecution.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStartExecution.setBounds(37, 11, 132, 23);
		btnStartExecution.addActionListener(this);
		contentPane.add(btnStartExecution);
		
		JButton btnResume = new JButton("Resume");
		btnResume.setBounds(176, 11, 89, 23);
		btnResume.addActionListener(this);
		contentPane.add(btnResume);
		
		JButton btnStop = new JButton("Pause");
		btnStop.setBounds(77, 45, 92, 23);
		btnStop.addActionListener(this);
		contentPane.add(btnStop);
		
		JButton btnStep = new JButton("Step");
		btnStep.setBounds(176, 45, 89, 23);
		btnStep.addActionListener(this);
		contentPane.add(btnStep);
		
		JButton btnViewRegisters = new JButton("View Registers");
		btnViewRegisters.setBounds(10, 100, 132, 23);
		btnViewRegisters.addActionListener(this);
		contentPane.add(btnViewRegisters);
		
		JButton btnViewDataMemory = new JButton("View Data Memory");
		btnViewDataMemory.setBounds(143, 100, 147, 23);
		btnViewDataMemory.addActionListener(this);
		contentPane.add(btnViewDataMemory);
		
		JButton btnViewInstructionMemory = new JButton("View Instruction Memory");
		btnViewInstructionMemory.setBounds(62, 128, 203, 23);
		btnViewInstructionMemory.addActionListener(this);
		contentPane.add(btnViewInstructionMemory);
		
		JLabel lblSpeed = new JLabel("Speed (In Seconds):");
		lblSpeed.setBounds(10, 162, 159, 14);
		contentPane.add(lblSpeed);
		
		textField = new JTextField();
		textField.setText(".75");
		textField.setBounds(163, 159, 47, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		controller.operation(e.getActionCommand());
	}
}


