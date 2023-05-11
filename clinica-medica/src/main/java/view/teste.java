package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class teste extends JFrame {
	 private JPanel panel;
	    private JPanel button1;
	    private JPanel button2;

	private JPanel contentPane;
	int d = 0;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste frame = new teste();
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
	public teste() {
		// Configurações da janela
        setTitle("Exemplo setComponentZOrder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(300, 200));
        setLocationRelativeTo(null);

        // Criação dos componentes
        panel = new JPanel(null); // Usamos um layout nulo para poder definir as posições dos componentes manualmente
        button1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) button1.getLayout();
        flowLayout.setAlignOnBaseline(true);
        panel.add(button1);

        // Define as posições dos componentes
        button1.setBounds(0, 0, 91, 161);

        // Define as cores dos botões para diferenciá-los
        button1.setBackground(Color.RED);
        button1.setVisible(false);

        // Define a ordem Z dos componentes
       // panel.setComponentZOrder(button1, 0);

        // Adiciona o painel à janela
        getContentPane().add(panel);
        button2 = new JPanel();
       
        button2.setBounds(0, 0, 284, 161);
      
        
                // Adiciona os componentes ao painel
                button2.setLayout(new MigLayout("", "[][][][][][][][][]", "[]"));
                button2.setBackground(Color.GREEN);
             //   panel.setComponentZOrder(button2, 0);
                
                btnNewButton = new JButton("New button");
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	
                		if(d==0) {
                			d++;
                			button1.setVisible(true);
                		}else {
                			button1.setVisible(false);
                			d=0;
                		}
                		
                	}
                });
                button2.add(btnNewButton, "cell 8 0");
                panel.add(button2);
	}

}
