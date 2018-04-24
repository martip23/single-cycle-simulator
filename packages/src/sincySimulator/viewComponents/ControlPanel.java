package sincySimulator.viewComponents;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ControlPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel frame = new ControlPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControlPanel() {
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
		contentPane.add(btnStartExecution);
		
		JButton btnResume = new JButton("Resume");
		btnResume.setBounds(176, 11, 89, 23);
		contentPane.add(btnResume);
		
		JButton btnStop = new JButton("Pause");
		btnStop.setBounds(77, 45, 92, 23);
		contentPane.add(btnStop);
		
		JButton btnStep = new JButton("Step");
		btnStep.setBounds(176, 45, 89, 23);
		contentPane.add(btnStep);
		
		JButton btnViewRegisters = new JButton("View Registers");
		btnViewRegisters.setBounds(10, 100, 132, 23);
		contentPane.add(btnViewRegisters);
		
		JButton btnViewDataMemory = new JButton("View Data Memory");
		btnViewDataMemory.setBounds(143, 100, 147, 23);
		contentPane.add(btnViewDataMemory);
		
		JButton btnViewInstructionMemory = new JButton("View Instruction Memory");
		btnViewInstructionMemory.setBounds(62, 128, 203, 23);
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
}
