package utils;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class RoundFormattedJTextField extends JFormattedTextField {

	private Shape shape;

	public RoundFormattedJTextField(int size, TipoFormatacao tipoFormatacao) {
		super(size);
		setOpaque(false);

//		MaskFormatter formatter = null;
//		if (tipoFormatacao == TipoFormatacao.CEP) {
//			try {
//				formatter = new MaskFormatter("#####-###");
//				
//				// TODO setar na superclasse a mascara
//				JFormattedTextField(formatter);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//
//		} else if (tipoFormatacao == TipoFormatacao.CPF) {
//			try {
//				formatter = new MaskFormatter("###.###.###-##");
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//
//		} else if (tipoFormatacao == TipoFormatacao.TELEFONE) {
//			try {
//				formatter = new MaskFormatter("(##)#####-####");
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//
//		} else if (tipoFormatacao == TipoFormatacao.DATA) {
//			try {
//				formatter = new MaskFormatter("##/##/####");
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//
//		}

	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}

}
