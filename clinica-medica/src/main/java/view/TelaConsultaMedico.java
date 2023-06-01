package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class TelaConsultaMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtTxtnome;
	private JTextField txtTxtcpf;
	private JTextField txtTelefone;
	private JTextField txt;
	private JTextField textField_4;
	private JTextField TXTHora;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaMedico frame = new TelaConsultaMedico();
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
	public TelaConsultaMedico() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1050);
		setMinimumSize(new Dimension(1250, 1000));
		
		JPanel panel = new JPanel();
		panel.setBounds(278, 118, 604, 830);
		panel.setBackground(new Color(236, 251, 234));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(880, 118, 713, 830);
		panel_1.setBackground(new Color(236, 251, 234));
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBounds(1743, 930, 145, 41);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1924, 68);
		panel_2.setBackground(new Color(143, 188, 143));
		
		JLabel lblNewLabel_1_1 = new JLabel("Situação da consulta : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1904, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(73)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)
					.addGap(921))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 68, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Diagnóstico clínico ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(62, 49, 345, 34);
		panel_1.add(lblNewLabel_8);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(62, 114, 569, 629);
		panel_1.add(textPane_1);
		panel.setLayout(null);
		
		txtTxtnome = new JTextField();
		txtTxtnome.setBounds(147, 239, 338, 31);
		panel.add(txtTxtnome);
		txtTxtnome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(79, 239, 69, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(99, 286, 49, 33);
		panel.add(lblNewLabel_2);
		
		txtTxtcpf = new JTextField();
		txtTxtcpf.setText("txtCPF");
		txtTxtcpf.setColumns(10);
		txtTxtcpf.setBounds(147, 280, 338, 33);
		panel.add(txtTxtcpf);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(56, 368, 93, 32);
		panel.add(lblNewLabel_3);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(147, 367, 338, 33);
		panel.add(txtTelefone);
		
		JLabel lblNewLabel_4 = new JLabel("Observação :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(34, 455, 115, 30);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Convenio :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(56, 411, 93, 33);
		panel.add(lblNewLabel_5);
		
		txt = new JTextField();
		txt.setColumns(10);
		txt.setBounds(147, 411, 338, 33);
		panel.add(txt);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(147, 455, 338, 87);
		panel.add(textPane);
		
		JLabel lblNewLabel_6 = new JLabel("Serviço :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(63, 553, 84, 33);
		panel.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(147, 553, 338, 33);
		panel.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("Hora :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(79, 324, 66, 33);
		panel.add(lblNewLabel);
		
		TXTHora = new JTextField();
		TXTHora.setColumns(10);
		TXTHora.setBounds(147, 324, 127, 33);
		panel.add(TXTHora);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(358, 324, 127, 33);
		panel.add(txtData);
		
		JLabel lblNewLabel_7 = new JLabel("Data :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(292, 324, 69, 32);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(234, 597, 147, 33);
		panel.add(btnNewButton_1);
		getContentPane().setLayout(null);
		getContentPane().add(panel_2);
		getContentPane().add(panel);
		getContentPane().add(panel_1);
		getContentPane().add(btnNewButton_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "1, 1, fill, fill");
	}
}
