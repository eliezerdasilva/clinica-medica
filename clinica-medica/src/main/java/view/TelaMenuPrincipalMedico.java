package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
*/
public class TelaMenuPrincipalMedico extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JPanel panel_1;
	int d = 0;
	private JPanel panel; 
	private JPanel panel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPrincipalMedico frame = new TelaMenuPrincipalMedico();
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
	public TelaMenuPrincipalMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1050);
		setMinimumSize(new Dimension(1250, 1000));;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 1924, 68);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[]", "[50:n:50]"));
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
			
				
				if(panel2 == null) {
					 panel2 = new JPanel();
					 panel2.setBorder(new LineBorder(new Color(255, 255, 255), 4));
					panel2.setBackground(new Color(0, 0, 255));
					panel2.setBounds(0, 68, 266, 930);
					panel2.setForeground(Color.BLACK);
					contentPane.add(panel2);
					panel2.setLayout(new MigLayout("", "[240:n]", "[][50:n][10:n][50:n][10:n][50:n][10:n][50:n]"));
					
					JButton btnNewButton = new JButton("Paciente");		
					btnNewButton.setBackground(SystemColor.controlHighlight);
					btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
					JLabel lblNewLabel = new JLabel("Cadastar");
					lblNewLabel.setForeground(SystemColor.window);
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel2.add(lblNewLabel, "cell 0 0,alignx center");
					btnNewButton.setForeground(Color.BLACK);
					//btnNewButton.setBackground(SystemColor.controlHighlight);
					btnNewButton.setBorder(null);
					panel2.add(btnNewButton, "cell 0 1,grow");			
					
					JButton btnNewButton_1 = new JButton("Médico");
					btnNewButton_1.setBackground(SystemColor.controlHighlight);
					btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnNewButton_1.setBorder(null);
					
					panel2.add(btnNewButton_1, "cell 0 3,grow");
					
					JButton btnNewButton_2 = new JButton("Funcionário");
					btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnNewButton_2.setBorder(null);
					btnNewButton_2.setBackground(SystemColor.controlHighlight);
					panel2.add(btnNewButton_2, "cell 0 5,grow");
					
					JButton btnNewButton_3 = new JButton("Consulta");
					btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnNewButton_3.setBorder(null);
					btnNewButton_3.setBackground(SystemColor.controlHighlight);
					panel2.add(btnNewButton_3, "cell 0 7,grow");

				}else {
					d =0; 
					panel.setVisible(false);
					contentPane.remove(panel2);
					panel_1 = null;
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\eliez\\OneDrive\\Documentos\\pi\\clinica-medica\\clinica-medica\\src\\main\\resources\\imagens\\botao-de-menu.png"));
		btnNewButton.setBackground(Color.white);
		panel.add(btnNewButton, "cell 0 0,grow");
		
		
	}
}
