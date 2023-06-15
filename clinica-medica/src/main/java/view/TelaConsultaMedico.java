package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.AgendaDao;
import model.Consulta;
import model.Usuario;

public class TelaConsultaMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtServico;
	private JTextField txtHora;
	private JTextField txtData;
	private Consulta consultaClick;
	private JTextPane txtObservacao;
	private JTextPane txtDiagnostico;
	private Usuario usuario;



	public TelaConsultaMedico(Consulta consulta, Usuario login) {
		this.usuario = login; 
		this.consultaClick = consulta; 
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Tela atendimento consulta");

		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1050);
		setMinimumSize(new Dimension(1250, 1000));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 0, (Color) new Color(143, 188, 143)));
		panel.setBounds(278, 118, 604, 830);
		panel.setBackground(new Color(236, 251, 234));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(3, 0, 3, 3, (Color)new Color(143, 188, 143)));
		panel_1.setBounds(880, 118, 713, 830);
		panel_1.setBackground(new Color(236, 251, 234));
		
		JButton btnVoltar = new JButton("Voltar menu principal");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(149, 208, 157));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipalMedico telaMenuPrincipalMedico = new TelaMenuPrincipalMedico(usuario);
				telaMenuPrincipalMedico.setLocationRelativeTo(null);
				telaMenuPrincipalMedico.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(1287, 959, 308, 41);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1924, 68);
		panel_2.setBackground(new Color(143, 188, 143));
		
		JLabel lblNewLabel_1_1 = new JLabel("Situação da consulta : ");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
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
		
		txtDiagnostico = new JTextPane();
		Border border = BorderFactory.createLineBorder(new Color(143, 188, 143),3);
		txtDiagnostico.setBorder(border);
		txtDiagnostico.setBounds(62, 114, 569, 629);
		panel_1.add(txtDiagnostico);
		panel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(147, 239, 338, 31);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(79, 239, 69, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(99, 286, 49, 33);
		panel.add(lblNewLabel_2);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(147, 280, 338, 33);
		panel.add(txtCpf);
		
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
		lblNewLabel_4.setBounds(33, 411, 115, 30);
		panel.add(lblNewLabel_4);
		
		txtObservacao = new JTextPane();
		 Border border2 = BorderFactory.createLineBorder(Color.black);
		 txtObservacao.setBorder(border2);
		txtObservacao.setBounds(147, 411, 338, 131);
		panel.add(txtObservacao);
		
		JLabel lblNewLabel_6 = new JLabel("Serviço :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(63, 553, 84, 33);
		panel.add(lblNewLabel_6);
		
		txtServico = new JTextField();
		txtServico.setColumns(10);
		txtServico.setBounds(147, 553, 338, 33);
		panel.add(txtServico);
		
		JLabel lblNewLabel = new JLabel("Hora :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(79, 324, 66, 33);
		panel.add(lblNewLabel);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(147, 324, 127, 33);
		panel.add(txtHora);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(358, 324, 127, 33);
		panel.add(txtData);
		
		JLabel lblNewLabel_7 = new JLabel("Data :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(292, 324, 69, 32);
		panel.add(lblNewLabel_7);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(new Color(255, 255, 255));
		btnFinalizar.setBackground(new Color(149, 208, 157));
		btnFinalizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AgendaDao agendaDao = new AgendaDao(); 
				consultaClick.setObservacao(txtObservacao.getText());
				consultaClick.setDiagnostico(txtDiagnostico.getText());
				boolean resultado = agendaDao.alterarConsultaMedico(consultaClick);
				if(resultado=true) {
					JOptionPane.showMessageDialog(null, "Consulta finalizada com sucesso");
				}else {
					JOptionPane.showMessageDialog(null, "Consulta finalizada com sucesso","Erro",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFinalizar.setBounds(234, 597, 147, 33);
		panel.add(btnFinalizar);
		getContentPane().setLayout(null);
		getContentPane().add(panel_2);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("src\\main\\resources\\imagens\\pessoa3e.png"));
		lblNewLabel_9.setBounds(168, 57, 259, 194);
		panel.add(lblNewLabel_9);
		getContentPane().add(panel_1);
		getContentPane().add(btnVoltar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "1, 1, fill, fill");
		setarDados(consulta);
	}
	private void setarDados(Consulta consulta) {
		
	
		txtNome.setText(consulta.getPaciente().getNome());
		txtNome.setEditable(false);
		txtCpf.setText(String.valueOf(consulta.getPaciente().getCpf()));
		txtCpf.setEditable(false);
		txtServico.setText(consulta.getServico());
		String date = String.valueOf(consulta.getDate());
		txtData.setText(date);
		txtData.setEditable(false);
		txtObservacao.setText(consulta.getObservacao());
		txtTelefone.setText(consulta.getPaciente().getTelefone());
		txtTelefone.setEditable(false);
		txtHora.setText(String.valueOf(consulta.getHora()));
		txtHora.setEditable(false);
		txtDiagnostico.setText(consulta.getDiagnostico());
		
	
	}
}
