package FiveGUI;

import java.awt.*;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		FiveGUIView frame = new FiveGUIView("Bai 6");
		frame.setSize(1024, 768);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
