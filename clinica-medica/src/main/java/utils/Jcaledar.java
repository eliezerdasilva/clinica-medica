package utils;

import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class Jcaledar extends JDateChooser{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jcaledar() {

	    }

	    public void setData(Date valor) {
	        setData(((Date) valor));
	    }

	    public Date getData() {
	        JDateChooser calendario = new JDateChooser(new Date(), "dd/MM/yyyy");
	        return (calendario.getDate());
	    }

}
