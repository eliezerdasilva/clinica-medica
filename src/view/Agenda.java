package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;


import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTable table;
	private JTextField txtValor;
	private JTextField txtData;
	private JTextField txtHora;
	//private AgendaController controler;
	private JComboBox comboBoxCliente; 
	private JComboBox comboBoxServico; 
	private JTextField txtobservacao;

	
	public Agenda() {
		setExtendedState(MAXIMIZED_BOTH);
		//controler = new AgendaController(this);
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1080, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(66, 33, 184, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 30, 64, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 58, 46, 18);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		controler.agendar();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(284, 327, 437, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(759, 25, 274, 197);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(201, 362, 619, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Cliente", "Servi\u00E7o", "Valor", "Hora", "Data", "Observacao"
			}
		));
		
		txtValor = new JTextField();
		txtValor.setBounds(66, 124, 184, 22);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtData = new JTextField();
		txtData.setBounds(66, 157, 184, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(66, 188, 184, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Serviço:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 94, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 127, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 159, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hora:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 190, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		
		
		comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(66, 64, 184, 22);
		contentPane.add(comboBoxCliente);
		
		comboBoxServico = new JComboBox();
		comboBoxServico.addItemListener(new ItemListener() {
			

			public void itemStateChanged(ItemEvent e) {
			//	controler.atualizaValor();
			}
		});
		comboBoxServico.setBounds(66, 91, 184, 22);
		contentPane.add(comboBoxServico);
		
		JLabel lblNewLabel_6 = new JLabel("Observacao");
		lblNewLabel_6.setBounds(10, 219, 72, 14);
		contentPane.add(lblNewLabel_6);
		
		txtobservacao = new JTextField();
		txtobservacao.setBounds(76, 219, 174, 20);
		contentPane.add(txtobservacao);
		txtobservacao.setColumns(10);
		
		Iniciar();
		

	}
	private void Iniciar() {
		/*controler.atualizaTabela();
		controler.atualizaCliente();
		controler.atualizaServico();
	
		*///controler.atualizaValor();
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JComboBox getComboBoxCliente() {
		return comboBoxCliente;
	}

	public void setComboBoxCliente(JComboBox comboBoxCliente) {
		this.comboBoxCliente = comboBoxCliente;
	}

	public JComboBox getComboBoxServico() {
		return comboBoxServico;
	}

	public void setComboBoxServico(JComboBox comboBoxServico) {
		this.comboBoxServico = comboBoxServico;
	}
	
	public JTextField getTxtID() {
		return txtID;
	}
	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}
	public JTextField getTxtData() {
		return txtData;
	}
	public void setTxtData(JTextField txtData) {
		this.txtData = txtData;
	}
	public JTextField getTxtHora() {
		return txtHora;
	}
	public void setTxtHora(JTextField txtHora) {
		this.txtHora = txtHora;
	}
	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}

	public JTextComponent getTxtValor() {
		// TODO Auto-generated method stub
		return txtValor;
	}
	public void setTxtobservacao(JTextField txtobservacao) {
		this.txtobservacao = txtobservacao;
	}
	public JTextComponent getTxtobservacao() {
		// TODO Auto-generated method stub
		return txtobservacao;
	}
	
}
