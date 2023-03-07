package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Usuario;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JScrollBar;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public MenuPrincipal(Usuario login) {
		setExtendedState(MAXIMIZED_BOTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 128, 128));
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		menuBar.setFont(new Font("Verdana", Font.BOLD, 17));
		menuBar.setMargin(new Insets(10, 100, 10, 10));
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Cadastro");

		mnNewMenu.setForeground(new Color(0, 128, 128));
		mnNewMenu.setPreferredSize(new Dimension(100, 40));
		mnNewMenu.setBorder(new LineBorder(new Color(0, 0, 0), 19, true));
		mnNewMenu.setBackground(Color.green);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Funcionario");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Paciente");
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Médico");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("Agendar");
		mnNewMenu_1.setBackground(new Color(0, 128, 0));
		mnNewMenu_1.setForeground(new Color(0, 128, 128));
		mnNewMenu_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		mnNewMenu_1.setPreferredSize(new Dimension(100, 40));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar");
		mntmNewMenuItem.setForeground(new Color(0, 128, 128));

		mntmNewMenuItem.setPreferredSize(new Dimension(150, 40));
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu mnNewMenu_2 = new JMenu("Consultar dados");
		mnNewMenu_2.setForeground(new Color(0, 128, 128));
		mnNewMenu_2.setPreferredSize(new Dimension(130, 40));
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_3 = new JMenu("Configuração\r\n");
		mnNewMenu_3.setForeground(new Color(0, 128, 128));
		mnNewMenu_3.setBorder(new LineBorder(new Color(0, 0, 0), 19, true));

		mnNewMenu_3.setPreferredSize(new Dimension(100, 40));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Sair");
		mnNewMenu_3.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Perfil");
		mnNewMenu_3.add(mntmNewMenuItem_4);

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, "name_432207963291300");
		panel.setLayout(new MigLayout("", "[100px,grow][802.00,grow][61.00px,grow][383.00px,grow][61px]", "[][::50px,grow][::537.00px,grow]"));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 1,grow");

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel.add(panel_2, "cell 1 1,grow");
		panel_2.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Consultas do dia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		panel_2.add(lblNewLabel, "name_433992018899300");

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "cell 0 2,grow");

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "cell 1 2,grow");
		panel_4.setLayout(new CardLayout(0, 0));
		panel_4.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(201, 362, 619, 197);
		panel_4.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "Cliente", "Servi\u00E7o", "Valor", "Hora", "Data", "Observacao" }));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "cell 3 2,grow");
		panel_5.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrados");
		panel_5.add(lblNewLabel_1, "cell 1 1");
		
		JLabel lblNewLabel_2 = new JLabel("Total de consulta / /");
		panel_5.add(lblNewLabel_2, "cell 1 3");
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_5.add(lblNewLabel_3, "cell 1 5");

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
