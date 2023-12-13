package StudentGUI;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws HeadlessException, ClassNotFoundException, SQLException {
		StudentViewApp frame = new StudentViewApp("Bai 7");
		frame.setSize(1024, 768);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
